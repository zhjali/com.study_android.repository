package merchantDetail;



public class coupon {
	private String id;
	private String source;
	private String title;
	private String start_time;
	private String end_time;
	private String use_type;
	private String useful;
	private String useless;
	private String description;

	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getUse_type() {
		return use_type;
	}

	public void setUse_type(String use_type) {
		this.use_type = use_type;
	}

	public String getUseful() {
		return useful;
	}

	public void setUseful(String useful) {
		this.useful = useful;
	}

	public String getUseless() {
		return useless;
	}

	public void setUseless(String useless) {
		this.useless = useless;
	}

	@Override
	public String toString() {
		return "coupon [id=" + id + ", source=" + source + ", title=" + title
				+ ", start_time=" + start_time + ", end_time=" + end_time
				+ ", use_type=" + use_type + ", useful=" + useful
				+ ", useless=" + useless + "]";
	}

}
