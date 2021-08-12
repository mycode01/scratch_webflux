package com.example.feign;

import java.io.Serializable;

public class MakeBlueprintRes implements Serializable {

  private final int statusCode;
  private final String statusMessage;
  private final BluePrintResBody body;

  public MakeBlueprintRes(int statusCode, String statusMessage,
      BluePrintResBody body) {
    this.statusCode = statusCode;
    this.statusMessage = statusMessage;
    this.body = body;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public String getStatusMessage() {
    return statusMessage;
  }

  public String getPathBlueprint() {
    return body.pathBlueprint;
  }

  public String getPathPreview() {
    return body.pathPreview;
  }

  public String getDesignKey() {
    return body.designKey;
  }

  public long getDesignId() {
    return body.designId;
  }

  public String getBlankProductId() {
    return body.blankProductId;
  }


  private static class BluePrintResBody {

    private final String pathBlueprint;
    private final String pathPreview;
    private final String designKey;
    private final long designId;
    private final String blankProductId;

    public BluePrintResBody(String pathBlueprint, String pathPreview, String designKey,
        long designId, String blankProductId) {
      this.pathBlueprint = pathBlueprint;
      this.pathPreview = pathPreview;
      this.designKey = designKey;
      this.designId = designId;
      this.blankProductId = blankProductId;
    }
  }
}