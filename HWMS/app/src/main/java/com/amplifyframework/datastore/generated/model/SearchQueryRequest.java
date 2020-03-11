package com.amplifyframework.datastore.generated.model;


import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the SearchQueryRequest type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "SearchQueryRequests")
public final class SearchQueryRequest implements Model {
  public static final QueryField ID = field("id");
  public static final QueryField PREDICTION = field("prediction");
  public static final QueryField ITEM = field("item");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="Boolean", isRequired = true) Boolean prediction;
  private final @ModelField(targetType="String", isRequired = true) String item;
  public String getId() {
      return id;
  }
  
  public Boolean getPrediction() {
      return prediction;
  }
  
  public String getItem() {
      return item;
  }
  
  private SearchQueryRequest(String id, Boolean prediction, String item) {
    this.id = id;
    this.prediction = prediction;
    this.item = item;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      SearchQueryRequest searchQueryRequest = (SearchQueryRequest) obj;
      return ObjectsCompat.equals(getId(), searchQueryRequest.getId()) &&
              ObjectsCompat.equals(getPrediction(), searchQueryRequest.getPrediction()) &&
              ObjectsCompat.equals(getItem(), searchQueryRequest.getItem());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getPrediction())
      .append(getItem())
      .toString()
      .hashCode();
  }
  
  public static PredictionStep builder() {
      return new Builder();
  }
  
  /** 
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   * @throws IllegalArgumentException Checks that ID is in the proper format
   **/
  public static SearchQueryRequest justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new SearchQueryRequest(
      id,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      prediction,
      item);
  }
  public interface PredictionStep {
    ItemStep prediction(Boolean prediction);
  }
  

  public interface ItemStep {
    BuildStep item(String item);
  }
  

  public interface BuildStep {
    SearchQueryRequest build();
    BuildStep id(String id) throws IllegalArgumentException;
  }
  

  public static class Builder implements PredictionStep, ItemStep, BuildStep {
    private String id;
    private Boolean prediction;
    private String item;
    @Override
     public SearchQueryRequest build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new SearchQueryRequest(
          id,
          prediction,
          item);
    }
    
    @Override
     public ItemStep prediction(Boolean prediction) {
        Objects.requireNonNull(prediction);
        this.prediction = prediction;
        return this;
    }
    
    @Override
     public BuildStep item(String item) {
        Objects.requireNonNull(item);
        this.item = item;
        return this;
    }
    
    /** 
     * WARNING: Do not set ID when creating a new object. Leave this blank and one will be auto generated for you.
     * This should only be set when referring to an already existing object.
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     * @throws IllegalArgumentException Checks that ID is in the proper format
     **/
    public BuildStep id(String id) throws IllegalArgumentException {
        this.id = id;
        
        try {
            UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
        } catch (Exception exception) {
          throw new IllegalArgumentException("Model IDs must be unique in the format of UUID.",
                    exception);
        }
        
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, Boolean prediction, String item) {
      super.id(id);
      super.prediction(prediction)
        .item(item);
    }
    
    @Override
     public CopyOfBuilder prediction(Boolean prediction) {
      return (CopyOfBuilder) super.prediction(prediction);
    }
    
    @Override
     public CopyOfBuilder item(String item) {
      return (CopyOfBuilder) super.item(item);
    }
  }
  
}
