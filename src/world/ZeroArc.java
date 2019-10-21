package world;

public class ZeroArc extends Arc {
    
    public ZeroArc(int id) {
    super(id );
    }
    
    public void changeState() {
        if (this.active == true) {
            this.active = false;
        }
        else {
            this.active = true;
        }
    }
    
    
    public boolean verifyActive() {
    	if(place.getNbrTokens()==0&&!output) {
			active=true;
		}
		else {
			active=false;
		}
		return active;
    }
    
}