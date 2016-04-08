package kmit.project.universityselectron;

public class University {
	
	     
	    public University() {
		super();
	}

		//private variables
	    int min_score;
	    int max_score;
	    String _name;
	    String _addr;
	    
	    
	    /**
		 * @return the min_score
		 */
		public  int getMin_score() {
			return min_score;
		}

		/**
		 * @param min_score the min_score to set
		 */
		public void setMin_score(int min_score) {
			this.min_score = min_score;
		}

		/**
		 * @return the max_score
		 */
		public int getMax_score() {
			return max_score;
		}


		/**
		 * @param max_score the max_score to set
		 */
		public void setMax_score(int max_score) {
			this.max_score = max_score;
		}

		/**
		 * @return the _name
		 */
		public String get_name() {
			return _name;
		}


		/**
		 * @param _name the _name to set
		 */
		public void set_name(String _name) {
			this._name = _name;
		}

		/**
		 * @return the _addr
		 */
		public String get_addr() {
			return _addr;
		}


		/**
		 * @param _addr the _addr to set
		 */
		public void set_addr(String _addr) {
			this._addr = _addr;
		}
 
	    // Empty constructor
	   
	    // constructor
	    public University( String name, String addr,int min_score,int max_score)
	    {
	        this._name = name;
	        this._addr = addr;
	        this.min_score = min_score;
	        this.max_score = max_score;
	    }
}
