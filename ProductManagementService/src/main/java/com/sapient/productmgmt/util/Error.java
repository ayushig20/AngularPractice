package com.sapient.productmgmt.util;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;

/**
 * Error
 */

@JsonInclude(Include.NON_NULL)
public class Error   {

	@JsonProperty("field")
	private String field;
	
	@JsonProperty("errorCode")
	private String errorCode = null;

	@JsonProperty("message")
	private String message = null;

	@JsonProperty("description")
	private String description = null;
	
	/**
	 * 
	 */
	public Error() {
		super();
	}


	public Error errorCode(String errorCode) {
		this.errorCode = errorCode;
		return this;
	}
	
	public Error(String errorCode, String message, String description) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.description = description;
	}


/**
 * @param errorCode
 * @param message
 * @param description
 * @param field
 * 
 */
public Error(String errorCode, String message, String description,String field) {
	super();
	this.errorCode = errorCode;
	this.message = message;
	this.description = description;
	this.field=field;
}


/**
   * Get code
   * @return code
  **/
  @ApiModelProperty(value = "")
  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public Error message(String message) {
    this.message = message;
    return this;
  }

   /**
   * Get message
   * @return message
  **/
  @ApiModelProperty(value = "")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Error description(String description) {
    //this.description = description;
    return this;
  }

   /**
   * Get fields
   * @return fields
  **/
 /* @ApiModelProperty(value = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }*/


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.errorCode, error.errorCode) &&
        Objects.equals(this.message, error.message)
        && Objects.equals(this.description, error.description)
        && Objects.equals(this.field, error.field);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errorCode, message,field,description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Error {\n");
    
    sb.append("    code: ").append(toIndentedString(errorCode)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    field: ").append(toIndentedString(field)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


}


