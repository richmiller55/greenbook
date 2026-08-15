o# Prompt for Chapter 3: The TRIDENT Conference

## Role and Task
You are a Principal Operations Research Analyst, a Military Logistics Historian, and a Senior Systems Architect specializing in WWII logistical pipelines.

Your task is to provide a highly detailed, professional-grade reference manual entry and simulation-specification document for **Chapter 3: The TRIDENT Conference** of the US Army Green Book *"Global Logistics and Strategy: 1943–1945"*. This document will be used to define the core database parameters, network topologies, capacity constraints, and state-transition logic for a high-fidelity, division-level WWII logistics simulator.

Do not write a generic summary or a high-school level study guide. Your response must be an intellectually rigorous and historically precise reference document.

---

## Required Response Structure and Content Guidelines

Your output must follow this exact structure, with no placeholder content:

### 1. Strategic Context & Modern Historical Perspective (Minimum 1000 words)
Provide a deep-dive, academic-level analysis of the strategic, political, and material tensions of this chapter. Incorporate modern historical perspectives and data available with the benefit of post-war declassifications and decades of logistical scholarship. Specifically address:
- **The Strategic Paradox:** How high-level Allied strategic plans (e.g., from conferences like Casablanca, TRIDENT, SEXTANT, QUADRANT) clashed with the physical limits of global shipping pools, combat loading capacities, and port clearance rates.
- **Inter-Service and Coalition Tensions:** Analyze command friction (such as the Services of Supply vs. Combat Commands, or Army vs. Navy, or US vs. British pooling arrangements).
- **Historical Era Context:**
  The TRIDENT Conference (Washington, May 1943) established global Allied strategy for the rest of 1943 and early 1944. It forced a critical evaluation of resource distribution between the European Theater of Operations (ETO), the Mediterranean (MTO), and the Pacific, balancing political pressures and material realities.
- **Modern Analytical Insights:**
  TRIDENT formalized the target date of May 1. 1944 for Operation OVERLORD. From a modern systems perspective, this decision established a hard timeline constraint on all global pipelines, making every other theater a secondary competitor for resources, particularly landing craft and heavy troop ships.

### 2. High-Fidelity Simulation Parameters & Real-World Metrics
Generate a comprehensive, structured reference table containing all critical historical constants, coefficients, and operational metrics discussed in this chapter or uncovered by modern scholarship. These will serve as raw database values for our simulator. Specifically, find and include the exact values for:
- Approved OVERLORD assault division target size at TRIDENT.
- Authorized Pacific air strength expansion (in squadrons) approved at TRIDENT.
- Calculated shipping allocation (tons/month) required to support Cartwheel and Central Pacific operations in mid-1943.
For each metric, provide a detailed historical explanation and strategic rationale, explaining how it should be represented in a simulation state (e.g., as a static constant, dynamic capacity cap, or efficiency coefficient).

### 3. Logistical Network Topology (Detailed Mermaid.js Flowchart)
Design a highly detailed, production-grade Mermaid.js diagram showing the logistical network topology, depots, staging areas, ports, convoy routes, and combat nodes of this chapter. You must model capacity limits, congestion delays, and alternative routing:
- **Simulation Focus:** Multi-Theater Priority and Weighted Resource Distribution. Modeling resource split based on theater-specific strategic weights and distance-related transit efficiency degradation.
- The diagram must represent the physical flow of supplies (e.g., tons of dry cargo, bulk petroleum, or ammunition) from POEs to final theater depots.

### 4. Mathematical Modeling & Simulation Formulas
Formulate the operational research equations representing the logistics bottleneck or resource allocation problem of this chapter.
- State the model using rigorous LaTeX mathematical formulation (use `$$` for block equations and `$` for inline expressions).
- Define all constants, variables, objective functions, and constraints.
- Provide a detailed explanation of the formulas:
  $$\text{Mathematical Concept: } S_i = \frac{W_i \cdot (1 - \theta_i)}{\sum_{j} W_j \cdot (1 - \theta_j)} \cdot C_{total}$$

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
package Logistics.Trident

import scala.collection.immutable.Map

case class Theater(name: String, weight: Double, distancePenalty: Double)

object TridentPrioritization:
  def allocateSupplies(
    theaters: List[Theater],
    totalSupplies: Double
  ): Map[String, Double] =
    val totalWeight = theaters.map(t => t.weight * (1.0 - t.distancePenalty)).sum
    if totalWeight <= 0.0 then Map.empty
    else
      theaters.map { t =>
        val adjustedWeight = t.weight * (1.0 - t.distancePenalty)
        t.name -> (adjustedWeight / totalWeight) * totalSupplies
      }.toMap
```

### 6. Graduate-Level Operational Analysis
Provide long-form, intellectually challenging, and mathematically grounded answers to the following strategic discussion questions, referencing historical outcomes and physical logistics principles:
- How did TRIDENT resolve the fundamental disagreement between Roosevelt and Churchill on the expansion of Mediterranean operations?
- To what extent did Pacific shipping requirements limit the ETO troop build-up scheduled at TRIDENT?
