/*
 * Modifier    Apha Beta Aphasub Gamma
 * public      Y    Y    Y       Y
 * protected   Y    Y    Y       N
 * no modif    Y    Y    N       N
 * private     Y    N    N       N
 */

package pond.goose;
import pond.shore.Ptak;
import static pond.shore.Ptak.*;

public class Bocian extends Ptak {
    public void getVar(){
        int s1 = s; // y,y,Y,y - extends Ptak required
        int s2 = new Ptak().s; // y,y,y,Y - public
        
        int i2 = i; // y,y,Y,n - extends Ptak required
        int i1 = new Ptak().i; // y,y,y,N - protected
        
        int k2 = k; // y,y,N,n
        int k1 = new Ptak().k; // y,y,n,N
        
        
        int r1 = Ptak.r; // Y
        // import static pond.shore.Ptak.*;
        // or
        // extends Ptak
        int r2 = r; // Y
    }
}
