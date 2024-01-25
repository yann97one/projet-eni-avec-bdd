package fr.eni.tp.filmotheque.controller;

import java.util.List;

import fr.eni.tp.filmotheque.bo.Membre;
import fr.eni.tp.filmotheque.bo.Participant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import fr.eni.tp.filmotheque.bll.FilmService;
import fr.eni.tp.filmotheque.bo.Film;
import fr.eni.tp.filmotheque.bo.Genre;

@Controller
@RequestMapping("/films")
// Injection de la liste des attributs en session
@SessionAttributes({ "genresEnSession", "participantsEnSession", "membreEnSession" })
public class FilmController {

	// Dépendance
	private FilmService filmService;

	public FilmController(FilmService filmService) {
		this.filmService = filmService;
	}

	@ModelAttribute("genresEnSession")
	public List<Genre> chargerGenres() {
		System.out.println("Chargement en Session - GENRES");
		return filmService.consulterGenres();
	}
	@ModelAttribute("participantsEnSession")
	public List<Participant> chargerLesParticipants() {
		System.out.println("Chargement en Session - PARTICIPANTS");
		return filmService.consulterParticipants();
	}

	/**
	 * La méthode réagit à l'url /films et la méthode Get du protocole HTTP
	 * 
	 * @param model -- pour injecter des données à la vue
	 * @return l'alias de la page à afficher
	 */
	@GetMapping
	public String afficherFilms(Model model) {
		System.out.println("\nTous les films : ");
		List<Film> films = filmService.consulterFilms();
		// Ajout des films dans le modèle
		model.addAttribute("films", films);
		return "view-films";
	}

	@GetMapping("/detail")
	public String afficherUnFilm(@RequestParam(name = "id", required = true) long id, Model model) {
		if (id > 0) {// L'identifiant en base commencera en 1
			Film film = filmService.consulterFilmParId(id);
			if (film != null) {
				// Ajout de l'instance dans le modèle
				model.addAttribute("film", film);
				return "view-film-detail";
			} else
				System.out.println("Film inconnu!!");
		} else {
			System.out.println("Identifiant inconnu");
		}
		// Par défaut redirection vers l'url pour afficher les films
		return "redirect:/films";
	}


	@GetMapping("/creer")
	public String creerFilm(Model model, @ModelAttribute("membreEnSession") Membre membre) {
		if (null != membre && membre.getId() > 0 && membre.isAdmin()) {
			model.addAttribute("film", new Film());
			return "view-film-form";
		} else {
			return "redirect:/films";
		}
	}

	@PostMapping("/creer")
	public String creerFilm(@ModelAttribute("film") Film film, @ModelAttribute("membreEnSession") Membre membre, @RequestParam("genreId") String idGenre) {
		if (null != membre && membre.getId() > 0 && membre.isAdmin()) {
			Genre genre = filmService.consulterGenreParId(Long.parseLong(idGenre));
			film.setGenre(genre);
			filmService.creerFilm(film);
		}
		return "redirect:/films";
	}

}
