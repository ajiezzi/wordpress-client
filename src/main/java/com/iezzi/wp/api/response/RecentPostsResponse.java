package com.iezzi.wp.api.response;

import java.util.List;

public class RecentPostsResponse {

	private String status;
	private int count;
	private List<Post> posts;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public class Post {
		
		private int id;
		private String title;
		private Author author;
		
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
		
		public Author getAuthor() {
			return author;
		}

		public void setAuthor(Author author) {
			this.author = author;
		}

		public class Author {
			
			private int id;
			private String slug;
			private String name;
			private String first_name;
			private String last_name;
			private String nickname;
			
			public int getId() {
				return id;
			}
			
			public void setId(int id) {
				this.id = id;
			}

			public String getSlug() {
				return slug;
			}

			public void setSlug(String slug) {
				this.slug = slug;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getFirst_name() {
				return first_name;
			}

			public void setFirst_name(String first_name) {
				this.first_name = first_name;
			}

			public String getLast_name() {
				return last_name;
			}

			public void setLast_name(String last_name) {
				this.last_name = last_name;
			}

			public String getNickname() {
				return nickname;
			}

			public void setNickname(String nickname) {
				this.nickname = nickname;
			}
			
		}
		
	}
	
}
