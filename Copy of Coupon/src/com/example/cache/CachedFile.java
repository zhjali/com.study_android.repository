package com.example.cache;

 class CachedFile implements Comparable<CachedFile> {
	private String name;
	private long length;
	private long modified;

	public CachedFile() {
		super();
	}

	public CachedFile(String name, long length, long modified) {
		super();
		this.name = name;
		this.length = length;
		this.modified = modified;
	}

	@Override
	public String toString() {
		return "CachedFile [name=" + name + ", length=" + length
				+ ", modified=" + modified + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (length ^ (length >>> 32));
		result = prime * result + (int) (modified ^ (modified >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CachedFile other = (CachedFile) obj;
		if (length != other.length)
			return false;
		if (modified != other.modified)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getLength() {
		return length;
	}

	public void setLength(long length) {
		this.length = length;
	}

	public long getModified() {
		return modified;
	}

	public void setModified(long modified) {
		this.modified = modified;
	}

	@Override
	public int compareTo(CachedFile other) {
		if(this.modified > other.modified){
			return -1;
		}
		else if(this.modified < other.modified){
			return 1;
		}
		return 0;
	}

}
