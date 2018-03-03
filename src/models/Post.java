package models;

public class Post {
	Integer id;
	Integer upvote;
	Integer downvote;
	String link;
	String title;

	public Post(Integer id, String title, Integer upvote, Integer downvote, String link) {
		this.id=id;
		this.title=title;
		this.upvote=upvote;
		this.downvote=downvote;
		this.link=link;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getUpvote() {
		return upvote;
	}

	public void setUpvote(Integer upvote) {
		this.upvote = upvote;
	}

	public Integer getDownvote() {
		return downvote;
	}

	public void setDownvote(Integer downvote) {
		this.downvote = downvote;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}


	
}
