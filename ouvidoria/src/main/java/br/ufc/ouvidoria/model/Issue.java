package br.ufc.ouvidoria.model;

public class Issue {

	public enum IssueType {
		RECLAMACAO
	}

	private IssueType type;
	private String content;

	private Issue() {
	}

	public static class IssueBuilder {

		private Issue instance = new Issue();

		public IssueBuilder type(IssueType type) {

			instance.type = type;
			return this;
		}

		public IssueBuilder content(String content) {

			instance.content = content;
			return this;
		}

		public Issue build() {

			return instance;
		}
	}

	// ----------------getters and setters--------------
	public IssueType getType() {
		return type;
	}

	public void setType(IssueType type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
