package com.albo.enuns;

import java.util.Objects;

public enum CreatorType {

	  WRITERS("writers"), COLORISTS("colorists"),
      EDITOR("editor"), PENCIELLER("penciller");
     
      private final String type;
     
      private CreatorType (String type){
              this.type = type;
      }
     
      public String getType() {
              return this.type;
      }
      
      public static CreatorType get(String value) {
              for(CreatorType type : CreatorType.values()) {
                      if(Objects.equals(value, type.getType())) {
                              return type;
                      }
              }
              return null;
      }
}
