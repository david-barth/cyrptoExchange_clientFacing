package com.crypto.exchange.server.importers;

@FunctionalInterface
public interface Importer {
    void doImportAndAnalytics(String assetKey);
}
