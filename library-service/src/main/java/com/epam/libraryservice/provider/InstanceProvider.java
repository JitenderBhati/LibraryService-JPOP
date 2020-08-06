package com.epam.libraryservice.provider;

import com.epam.libraryservice.pojo.Library;
import com.epam.libraryservice.pojo.LibraryInfo;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class InstanceProvider {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Library getLibraryInstance() {
        return new Library();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public LibraryInfo getLibraryInfoInsatnce() {
        return new LibraryInfo();
    }
}
