package burp.rule.utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.yaml.snakeyaml.representer.Representer;

/**
 * @author EvilChen
 */

public class YamlTool {

    public static Yaml newStandardYaml() {
        DumperOptions dop = new DumperOptions();
        dop.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        Representer representer = new Representer();
        return new Yaml(representer, dop);
    }

    public static Map<String, Object> loadYaml(String filePath) {
        try {
            InputStream inputStream = Files.newInputStream(Paths.get(filePath));
            return newStandardYaml().load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
