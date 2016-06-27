package com.iezzi.wp.api.response;

public class PerspectivesResponse {

	private String status;
	private Post post;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
	public class Post {
		
		private int id;
		private CustomFields custom_fields;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public CustomFields getCustom_fields() {
			return custom_fields;
		}

		public void setCustom_fields(CustomFields custom_fields) {
			this.custom_fields = custom_fields;
		}
		
		public class CustomFields {
			
			private String[] perspective_overview;
			private String[] perspective_question;
			
			public String[] getPerspective_overview() {
				return perspective_overview;
			}
			
			public void setPerspective_overview(String[] perspective_overview) {
				this.perspective_overview = perspective_overview;
			}
			
			public String[] getPerspective_question() {
				return perspective_question;
			}
			
			public void setPerspective_question(String[] perspective_question) {
				this.perspective_question = perspective_question;
			}

		}
		
	}
	
}
