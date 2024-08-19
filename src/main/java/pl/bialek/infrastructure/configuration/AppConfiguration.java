package pl.bialek.infrastructure.configuration;

import pl.bialek.ComponentScanMarker;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackageClasses = ComponentScanMarker.class)
@Import(JPAConfiguration.class )
public class AppConfiguration {
}
