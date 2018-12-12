package helgalis.selfreview.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reviews")
public class Review {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String link;
	@Column(name="preview")
	private String text;
	
	private Film film;
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@ManyToOne
	@JoinColumn(name="film_id",referencedColumnName="id")
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	@Override
	public boolean equals(Object obj) {
		return false;
	}
	@Override 
	public int hashCode() {
		return 0;
	}
	@Override
	public String toString() {
		return getLink()+" "+getText();
	}
}
