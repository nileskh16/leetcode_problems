package com.plural.spring.fundamentals.listeners;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

@Component
@RequiredArgsConstructor
public class GenericEventListener extends AbstractMongoEventListener<Object> {

    private final MongoTemplate mongoTemplate;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Object> event) {
        Object source = event.getSource();
        ReflectionUtils.doWithLocalFields(source.getClass(), (localField) -> {
            ReflectionUtils.makeAccessible(localField);

            if (localField.isAnnotationPresent(DBRef.class)) {
                final Object value = localField.get(source);
                mongoTemplate.save(value);
            }
        });
    }
}
