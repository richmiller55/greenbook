# Prompt for Chapter 10: Ships, Landing Craft, and Strategy

## Role and Task
You are a Principal Operations Research Analyst, a Military Logistics Historian, and a Senior Systems Architect specializing in WWII logistical pipelines.

Your task is to provide a highly detailed, professional-grade reference manual entry and simulation-specification document for **Chapter 10: Ships, Landing Craft, and Strategy** of the US Army Green Book *"Global Logistics and Strategy: 1943–1945"*. This document will be used to define the core database parameters, network topologies, capacity constraints, and state-transition logic for a high-fidelity, division-level WWII logistics simulator.

Do not write a generic summary or a high-school level study guide. Your response must be an intellectually rigorous and historically precise reference document.

---

## Required Response Structure and Content Guidelines

Your output must follow this exact structure, with no placeholder content:

### 1. Strategic Context & Modern Historical Perspective (Minimum 1000 words)
Provide a deep-dive, academic-level analysis of the strategic, political, and material tensions of this chapter. Incorporate modern historical perspectives and data available with the benefit of post-war declassifications and decades of logistical scholarship. Specifically address:
- **The Strategic Paradox:** How high-level Allied strategic plans (e.g., from conferences like Casablanca, TRIDENT, SEXTANT, QUADRANT) clashed with the physical limits of global shipping pools, combat loading capacities, and port clearance rates.
- **Inter-Service and Coalition Tensions:** Analyze command friction (such as the Services of Supply vs. Combat Commands, or Army vs. Navy, or US vs. British pooling arrangements).
- **Historical Era Context:**
  This chapter serves as a deep dive into the supreme constraint of the European war: shipping and landing craft. It examines the competition for steel, shipyard capacities, and the impact of landing craft production on the global strategic timeline.
- **Modern Analytical Insights:**
  Modern analysis indicates that landing craft production (specifically LSTs) competed directly with the Navy's Destroyer Escort (DE) program. The JCS and President Roosevelt frequently shifted shipyard steel priorities based on the immediacy of the U-boat threat vs. amphibious plans, resulting in a volatile, highly unpredictable supply of landing craft for planners.

### 2. High-Fidelity Simulation Parameters & Real-World Metrics
Generate a comprehensive, structured reference table containing all critical historical constants, coefficients, and operational metrics discussed in this chapter or uncovered by modern scholarship. These will serve as raw database values for our simulator. Specifically, find and include the exact values for:
- Total Liberty ships completed by US shipyards in the peak year of 1943.
- Global deficit in LST production compared to ETO planners' requirements in late 1943.
- Standard building duration (days) of an LST in a Kaiser shipyard in 1943.
For each metric, provide a detailed historical explanation and strategic rationale, explaining how it should be represented in a simulation state (e.g., as a static constant, dynamic capacity cap, or efficiency coefficient).

### 3. Logistical Network Topology (Detailed Mermaid.js Flowchart)
Design a highly detailed, production-grade Mermaid.js diagram showing the logistical network topology, depots, staging areas, ports, convoy routes, and combat nodes of this chapter. You must model capacity limits, congestion delays, and alternative routing:
- **Simulation Focus:** Fleet Dynamics with Production and Operational Attrition. Modeling fleet pool projections over time under constant production and attrition rates.
- The diagram must represent the physical flow of supplies (e.g., tons of dry cargo, bulk petroleum, or ammunition) from POEs to final theater depots.

### 4. Mathematical Modeling & Simulation Formulas
Formulate the operational research equations representing the logistics bottleneck or resource allocation problem of this chapter.
- State the model using rigorous LaTeX mathematical formulation (use `$$` for block equations and `$` for inline expressions).
- Define all constants, variables, objective functions, and constraints.
- Provide a detailed explanation of the formulas:
  $$\text{Mathematical Concept: } F_{t+1} = F_t + P_t - A_t \cdot F_t$$

### 5. Compile-Safe Scala 3.8.3 Domain Model
Write a complete, highly-idiomatic, and production-ready Scala 3.8.3 domain model representing this mathematical system. This code will be directly integrated into our simulator's execution engine.
- **Strict Architecture Rules:**
  1. Use Scala 3's clean, curly-brace-free layout (indentation-based syntax).
  2. Use explicit type declarations for all public/protected methods and values.
  3. No wildcard imports; import symbols explicitly and group them at the top.
  4. Use strong, precise types: `opaque type` aliases for unit safety (e.g., NauticalMiles, Tons, Days), `enum` for state transitions, and sealed traits/case classes for domain ADTs.
  5. **Absolute Rule:** The code must compile perfectly and contain NO placeholders (`???`, `// TODO`, `...`, or commented-out sections). It must be fully implemented and correct.

Start with the following base and extend it into a comprehensive simulation module with additional parameters, state transitions, and validation checks:
```scala
package Logistics.ShipsLandingCraft

case class FleetState(ships: Int)

object FleetAttritionModel:
  def projectFleetSize(
    initialState: FleetState,
    monthlyProduction: Int,
    attritionRate: Double,
    months: Int
  ): FleetState =
    val finalShips = (1 to months).foldLeft(initialState.ships.toDouble) { (current, _) =>
      current + monthlyProduction - (attritionRate * current)
    }
    FleetState(finalShips.toInt)
```

### 6. Graduate-Level Operational Analysis
Provide long-form, intellectually challenging, and mathematically grounded answers to the following strategic discussion questions, referencing historical outcomes and physical logistics principles:
- Explain why the LST was considered the 'unanimous bottleneck' of World War II logistics.
- How did the division of steel between the Navy's combatant ship program and the Maritime Commission's merchant program affect overall strategy?
