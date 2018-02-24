 package helgalis.selfreview.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
 @Table(name="directors")
public class Director {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@ManyToMany
	@JoinTable(name="filmsdirectors",joinColumns=@JoinColumn(name="director_id"),
	inverseJoinColumns=@JoinColumn(name="film_id"))
	//@ManyToMany(mappedBy = "directors")
	private
	Set<Film> films = new HashSet<Film>();
	public Director() {
		
	}
	public Director(String name) {
		setName(name);
	}
	/*public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}*/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Set<Film> getFilms() {
		return films;
	}
	public void setFilms(Set<Film> films) {
		this.films = films;
	}
	@Override
	public String toString() {
		return getName();
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(!(obj instanceof Film))
			return false;
		Director d = (Director) obj;
		if(name!=null?!name.equals(d.name):d.name!=null)
			return false;
		else
			return true;
	}
	@Override 
	public int hashCode() {
		return name!=null?name.hashCode():0;
	}
}
