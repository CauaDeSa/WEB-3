package br.edu.ifsp.arqweb1.ifitness.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Activity implements Serializable {

	private static final long serialVersionUID = -5912269963563381684L;

	private Long id;
	private ActivityType type;
	private LocalDate date;
	private Double duration;
	private Double distance;
	private User user;
	
	public Activity(ActivityType type, LocalDate date, Double duration, Double distance, User user) {
		this.type = type;
		this.date = date;
		this.duration = duration;
		this.distance = distance;
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
        this.user = user;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ActivityType getType() {
		return type;
	}

	public void setType(ActivityType type) {
		this.type = type;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activity other = (Activity) obj;
		return Objects.equals(id, other.id);
	}

}