package com.iezzi.wp.api.response;

public class OverviewResponse {

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
			
			private String[] overview_primary;

			public String[] getOverview_primary() {
				return overview_primary;
			}

			public void setOverview_primary(String[] overview_primary) {
				this.overview_primary = overview_primary;
			}
			
		}
		
	}
}
