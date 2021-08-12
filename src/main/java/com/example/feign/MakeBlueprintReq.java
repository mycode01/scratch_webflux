package com.example.feign;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.io.Serializable;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MakeBlueprintReq implements Serializable {

  private final String userImageUrl;
  private final String guideUrl;
  private final String mockUrl;
  private final String bgUrl;
  private final String outlineUrl;

  private final double angle;
  private final double extRatio;
  private final String flipMode;
  private final int rotateOriginTop;
  private final int rotateOriginLeft;
  private final String color;
  private final int dpi;

  private final String blankProductId;
  private final String designKey;

  private final String pathBlueprint;
  private final String pathPreview;

  public MakeBlueprintReq(String userImageUrl, String guideUrl, String mockUrl, String bgUrl,
      String outlineUrl, double angle, double extRatio, String flipMode, int rotateOriginTop,
      int rotateOriginLeft, String color, int dpi, String blankProductId,
      String designKey, String pathBlueprint, String pathPreview) {
    this.userImageUrl = userImageUrl;
    this.guideUrl = guideUrl;
    this.mockUrl = mockUrl;
    this.bgUrl = bgUrl;
    this.outlineUrl = outlineUrl;
    this.angle = angle;
    this.extRatio = extRatio;
    this.flipMode = flipMode;
    this.rotateOriginTop = rotateOriginTop;
    this.rotateOriginLeft = rotateOriginLeft;
    this.color = color;
    this.dpi = dpi;
    this.blankProductId = blankProductId;
    this.designKey = designKey;
    this.pathBlueprint = pathBlueprint;
    this.pathPreview = pathPreview;
  }

  public String getUserImageUrl() {
    return userImageUrl;
  }

  public String getGuideUrl() {
    return guideUrl;
  }

  public String getMockUrl() {
    return mockUrl;
  }

  public String getBgUrl() {
    return bgUrl;
  }

  public String getOutlineUrl() {
    return outlineUrl;
  }

  public double getAngle() {
    return angle;
  }

  public double getExtRatio() {
    return extRatio;
  }

  public String getFlipMode() {
    return flipMode;
  }

  public int getRotateOriginTop() {
    return rotateOriginTop;
  }

  public int getRotateOriginLeft() {
    return rotateOriginLeft;
  }

  public String getColor() {
    return color;
  }

  public int getDpi() {
    return dpi;
  }

  public String getBlankProductId() {
    return blankProductId;
  }

  public String getDesignKey() {
    return designKey;
  }

  public String getPathBlueprint() {
    return pathBlueprint;
  }

  public String getPathPreview() {
    return pathPreview;
  }
}

//{
//    'user_image_url': 'BUILDER/original/16f63ef68d70004/mycode01/I17ad1d098f10012.png',
//    'guide_url': 'OMS/BLANK_PRODUCT/162606908745935/designTransparency.png',
//    'mock_url': 'OMS/BLANK_PRODUCT/162606908745935/designImage.png',
//    'bg_url': 'OMS/BLANK_PRODUCT/162606908745935/designWhite.png',
//    'outline_url': None,
//    'angle': 156.7565767608616,
//    'ext_ratio': 6.639744290662089,
//    'flip_mode': 'NONE',
//    'rotate_origin_top': 3084,
//    'rotate_origin_left': 4089,
//    'color': '#ff0000',
//    'blank_product_id': '162606908745935',
//    'dpi': 300,
//    'id': 486,
//    'design_key': '123123d',
//    'path_preview': 'BUILDER/makerPreview/p/user/filename.png',
//    'path_design': 'BUILDER/makerDesign/p/user/filename.png'
//}