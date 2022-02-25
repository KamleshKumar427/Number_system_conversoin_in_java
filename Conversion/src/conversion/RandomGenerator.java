/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversion;

import java.util.Random;

/**
 *
 * @author Afra
 */
public class RandomGenerator {
    
    int key;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public RandomGenerator(int key) {
        this.key = key;
    }
    
    public int generateColumns(){
        
        int rand=(int)Math.random();
        
        return rand;
    }
}
