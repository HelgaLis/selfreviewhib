package helgalis.selfreview.model;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="films")
public class Film {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column
	private String title;
	@ManyToMany
	@JoinTable(name="filmsdirectors",joinColumns=@JoinColumn(name="film_id"),
	inverseJoinColumns=@JoinColumn(name="director_id"))
	private List<Director> directors = new ArrayList<>();
	@Temporal(TemporalType.DATE)
	@Column(name="release_date")
	private Date releaseDate;
	@Column
	private String description;
	@OneToMany(mappedBy="film",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Review> reviews;
	//private List<Genre> genres;
	//private List<Keyword> keywords;
	@Temporal(TemporalType.DATE)
	@Column(name="view_date")
	private Date viewDate;
	@Column(name="self_review")
	private String selfReview;
	/*public Film(){
		reviews = new ArrayList<>();
		setGenres(new ArrayList<>());
		setKeywords(new ArrayList<>());
	}*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	/*
	public Film(String title, List<Director> directors, Date releaseDate) {
		super();
		setTitle(title);
		setDirectors(directors);
		setReleaseDate(releaseDate);
		
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Director> getDirectors() {
		return directors;
	}
	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public List<Genre> getGenres() {
		return genres;
	}
	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}
	public List<Keyword> getKeywords() {
		return keywords;
	}
	public void setKeywords(List<Keyword> keywords) {
		this.keywords = keywords;
	}*/
	@Override
	public String toString() {
		String str = title+" "+directors;
		return str;
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(!(obj instanceof Film))
			return false;
		Film f = (Film) obj;
		if(title!=null?!title.equals(f.title):f.title!=null)
			return false;
		else
			return true;
		
	}
	@Override 
	public int hashCode() {
		return title!=null?title.hashCode():0;
	}
}
