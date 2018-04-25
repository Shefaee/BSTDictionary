/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst.dictionary;

/**
 *
 * @author ModernCombat
 */
public class words implements  Comparable<words>{
   private String en;
   private String fa;

    public words(String en, String fa) {
        this.en = en;
        this.fa = fa;
    }

    public words() {}

    
    @Override
    public int compareTo(words o) 
    {
        if (this.equals(o)) return 0;
        return this.toString().compareTo(o.toString());
    }
    
    public String geten()
    {
        return this.en;
    }

    @Override
    public String toString() {
        return "(En: " + en + " Fa: " + fa + ") ";
    }

    @Override
    public boolean equals(Object obj) {
        words oobj = (words) obj;
        return (this.toString().equals(oobj.toString()));
    }
}
