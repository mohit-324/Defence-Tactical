package com.defence.tactical.ports.inbound;

import com.defence.tactical.core.model.TacticalAsset;

public interface ManageAssetUseCase {
    TacticalAsset deployAsset(TacticalAsset asset);
    
    // Add this missing method signature
    TacticalAsset getAssetDetails(String assetId);
}
