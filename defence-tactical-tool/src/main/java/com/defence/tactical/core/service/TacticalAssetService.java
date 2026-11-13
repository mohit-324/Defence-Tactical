package com.defence.tactical.core.service;

import com.defence.tactical.core.model.TacticalAsset;
import com.defence.tactical.ports.inbound.ManageAssetUseCase;
import com.defence.tactical.core.ports.outbound.CryptoPort;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TacticalAssetService implements ManageAssetUseCase {

    private final CryptoPort cryptoPort;
    private final Map<String, TacticalAsset> assetStore = new ConcurrentHashMap<>();

    public TacticalAssetService(CryptoPort cryptoPort) {
        this.cryptoPort = cryptoPort;
    }

    @Override
    public TacticalAsset deployAsset(TacticalAsset asset) {
        // Call cryptoPort method here if needed, then store asset
        assetStore.put(asset.getId(), asset); // Adjust getId() if ID is Long or another getter
        return asset;
    }

    @Override
    public TacticalAsset getAssetDetails(String assetId) {
        TacticalAsset asset = assetStore.get(assetId);
        if (asset == null) {
            throw new RuntimeException("Asset not found: " + assetId);
        }
        return asset;
    }
}
