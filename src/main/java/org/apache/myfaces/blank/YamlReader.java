package org.apache.myfaces.blank;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;


public class YamlReader {

  private static Map<String, Map<String, Object>> properties = new HashMap();

  /**
   * 单例
   */
  public static final YamlReader instance = new YamlReader();

  static {
    Yaml yaml = new Yaml();
    InputStream in = YamlReader.class.getClassLoader().getResourceAsStream("application.yml");
    properties = yaml.loadAs(in, HashMap.class);

  }

  /**
   * get yaml property
   *
   * @param key
   * @return
   */
  public Object getValueByKey(String key) {
    String separator = ".";
    String[] separatorKeys = null;
    if (key.contains(separator)) {
      separatorKeys = key.split("\\.");
    } else {
      return properties.get(key);
    }
    Map<String, Object> finalValue = new HashMap();
    for (int i = 0; i < separatorKeys.length-1; i++) {
      if (i == 0) {
        finalValue = (Map) properties.get(separatorKeys[i]);
        continue;
      }
      if (finalValue == null) {
        break;
      }
      if (finalValue.get(separatorKeys[i]) instanceof Map) {
        finalValue = (Map) finalValue.get(separatorKeys[i]);
      } else if (finalValue.get(separatorKeys[i]) instanceof List) {

      }
    }
    return finalValue == null ? null : finalValue.get(separatorKeys[separatorKeys.length - 1]);
  }

  public static void main(String[] args) {
    Object serverHost = YamlReader.instance.getValueByKey("a.b.c.f");
    if (serverHost instanceof List) {
      List<String> xxx=(List<String>)serverHost;
      System.out.println(xxx);
    }
  }
}
