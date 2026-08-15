# Prompt for Chapter 2: Husky and Bolero

## Role and Task
You are a Principal Operations Research Analyst, a Military Logistics Historian, and a Senior Systems Architect specializing in WWII logistical pipelines.

Your task is to provide a highly detailed, professional-grade reference manual entry and simulation-specification document for **Chapter 2: Husky and Bolero** of the US Army Green Book *"Global Logistics and Strategy: 1943–1945"*. This document will be used to define the core database parameters, network topologies, capacity constraints, and state-transition logic for a high-fidelity, division-level WWII logistics simulator.

Do not write a generic summary or a high-school level study guide. Your response must be an intellectually rigorous and historically precise reference document.

---

## Required Response Structure and Content Guidelines

Your output must follow this exact structure, with no placeholder content:

### 1. Strategic Context & Modern Historical Perspective (Minimum 1000 words)
Provide a deep-dive, academic-level analysis of the strategic, political, and material tensions of this chapter. Incorporate modern historical perspectives and data available with the benefit of post-war declassifications and decades of logistical scholarship. Specifically address:
- **The Strategic Paradox:** How high-level Allied strategic plans (e.g., from conferences like Casablanca, TRIDENT, SEXTANT, QUADRANT) clashed with the physical limits of global shipping pools, combat loading capacities, and port clearance rates.
- **Inter-Service and Coalition Tensions:** Analyze command friction (such as the Services of Supply vs. Combat Commands, or Army vs. Navy, or US vs. British pooling arrangements).
- **Historical Era Context:**
  The planning for the invasion of Sicily (Operation HUSKY) in mid-1943 directly conflicted with the BOLERO build-up in the United Kingdom. This chapter highlights the critical shortage of amphibious shipping, specifically LSTs (Landing Ship, Tank), LCIs, and LCTs, and the struggle to balance short-term tactical operations against long-term strategic build-up.
- **Modern Analytical Insights:**
  Modern analysis reveals that the shortage of landing craft was exacerbated by competing demands from the Pacific theater, which Nimitz and MacArthur claimed were non-negotiable. Furthermore, combat loading of vessels (which reduced effective cargo capacity by up to 60%) was not fully factored into early transit models, leading to severe logistical shortfalls in Sicily.

### 2. High-Fidelity Simulation Parameters & Real-World Metrics
Generate a comprehensive, structured reference table containing all critical historical constants, coefficients, and operational metrics discussed in this chapter or uncovered by modern scholarship. These will serve as raw database values for our simulator. Specifically, find and include the exact values for:
- Total LSTs required for HUSKY assault vs. LSTs withdrawn from the BOLERO pool.
- May 1943 actual troop strength in the United Kingdom vs. the original BOLERO target.
- Effective cargo carrying capacity reduction percentage of a combat-loaded troop transport compared to an administratively loaded merchant ship.
For each metric, provide a detailed historical explanation and strategic rationale, explaining how it should be represented in a simulation state (e.g., as a static constant, dynamic capacity cap, or efficiency coefficient).

### 3. Logistical Network Topology (Detailed Mermaid.js Flowchart)
Design a highly detailed, production-grade Mermaid.js diagram showing the logistical network topology, depots, staging areas, ports, convoy routes, and combat nodes of this chapter. You must model capacity limits, congestion delays, and alternative routing:
- **Simulation Focus:** Resource Allocation Under Theater Constraints. Optimizing the split of a finite landing craft pool between HUSKY (MTO) and BOLERO (ETO) to meet minimum tactical assault and strategic build-up thresholds.
- The diagram must represent the physical flow of supplies (e.g., tons of dry cargo, bulk petroleum, or ammunition) from POEs to final theater depots.

### 4. Mathematical Modeling & Simulation Formulas
Formulate the operational research equations representing the logistics bottleneck or resource allocation problem of this chapter.
- State the model using rigorous LaTeX mathematical formulation (use `$$` for block equations and `$` for inline expressions).
- Define all constants, variables, objective functions, and constraints.
- Provide a detailed explanation of the formulas:
  $$\text{Mathematical Concept: } X_{H} + X_{B} \le C_{total}, \quad X_{H} \ge X_{H}^{min}, \quad X_{B} \ge X_{B}^{min}$$

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
package Logistics.HuskyBolero

import scala.collection.immutable.List

case class CraftPool(totalLST: Int)

case class Allocation(huskyLST: Int, boleroLST: Int):
  def isValid(pool: CraftPool): Boolean =
    huskyLST + boleroLST <= pool.totalLST

object ResourceAllocator:
  def findFeasibleAllocations(
    pool: CraftPool,
    minHusky: Int,
    minBolero: Int
  ): List[Allocation] =
    for
      h <- (minHusky to pool.totalLST).toList
      b = pool.totalLST - h
      if b >= minBolero
    yield Allocation(h, b)
```

### 6. Graduate-Level Operational Analysis
Provide long-form, intellectually challenging, and mathematically grounded answers to the following strategic discussion questions, referencing historical outcomes and physical logistics principles:
- How did the British and American viewpoints differ at the Washington Conference regarding the trade-offs between HUSKY and BOLERO?
- What role did the 'Anvil' (later 'Dragoon') debate play in the landing craft allocation disputes of early 1943?
- Explain how the introduction of the 2.5-ton amphibious truck (DUKW) mitigated port discharge limitations during HUSKY.
