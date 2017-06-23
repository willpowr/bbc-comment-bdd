package com.willpoweru.bbc.helpers;

public class RandomText {

  public RandomText(){

  }

  public static String makeText(){
    return Long.toHexString(
            Double.doubleToLongBits(Math.random()));
  }

}
