package com.daisuzz.samplethymeleaftodo.configuration;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;

import java.util.Collection;

public class ListStringEditor extends CustomCollectionEditor {

    public ListStringEditor(Class<? extends Collection> collectionType) {
        super(collectionType);
    }

    public ListStringEditor(Class<? extends Collection> collectionType, boolean nullAsEmptyCollection) {
        super(collectionType, nullAsEmptyCollection);
    }

    @Override
    protected Object convertElement(@NotNull Object element) {
        if (element instanceof String) {
            String str = (String) element;
            if (str.isBlank()) {
                return null;
            }
        }

        return element;
    }
}
