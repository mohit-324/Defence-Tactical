package com.defence.tactical.adapters.inbound.rest;

import com.defence.tactical.core.model.TacticalAsset;
import com.defence.tactical.ports.inbound.ManageAssetUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/assets")
public class TacticalAssetController {

    private final ManageAssetUseCase manageAssetUseCase;

    // Injection via Constructor (Typically points to a Service Core implementing the UseCase)
    public TacticalAssetController(ManageAssetUseCase manageAssetUseCase) {
        this.manageAssetUseCase = manageAssetUseCase;
    }

    @PostMapping("/deploy")
    public ResponseEntity<TacticalAsset> deployAsset(@RequestBody TacticalAsset asset) {
        TacticalAsset deployed = manageAssetUseCase.deployAsset(asset);
        return ResponseEntity.ok(deployed);
    }

   @GetMapping("/{id}")
public ResponseEntity<TacticalAsset> getAssetDetails(@PathVariable String id) {
    TacticalAsset asset = manageAssetUseCase.getAssetDetails(id);
    return ResponseEntity.ok(asset);
}

}
