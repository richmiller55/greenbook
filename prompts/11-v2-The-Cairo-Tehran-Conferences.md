# Prompt for Chapter 11: The Cairo-Tehran Conferences (SEXTANT/EUREKA)

## Role and Task
You are a Principal Operations Research Analyst, a Military Logistics Historian, and a Senior Systems Architect specializing in WWII logistical pipelines.

Your task is to provide a highly detailed, professional-grade reference manual entry and simulation-specification document for **Chapter 11: The Cairo-Tehran Conferences (SEXTANT/EUREKA)** of the US Army Green Book *"Global Logistics and Strategy: 1943–1945"*. This document will be used to define the core database parameters, network topologies, capacity constraints, and state-transition logic for a high-fidelity, division-level WWII logistics simulator.

Do not write a generic summary or a high-school level study guide. Your response must be an intellectually rigorous and historically precise reference document.

---

## Required Response Structure and Content Guidelines

Your output must follow this exact structure, with no placeholder content:

### 1. Strategic Context & Modern Historical Perspective (Minimum 1000 words)
Provide a deep-dive, academic-level analysis of the strategic, political, and material tensions of this chapter. Incorporate modern historical perspectives and data available with the benefit of post-war declassifications and decades of logistical scholarship. Specifically address:
- **The Strategic Paradox:** How high-level Allied strategic plans (e.g., from conferences like Casablanca, TRIDENT, SEXTANT, QUADRANT) clashed with the physical limits of global shipping pools, combat loading capacities, and port clearance rates.
- **Inter-Service and Coalition Tensions:** Analyze command friction (such as the Services of Supply vs. Combat Commands, or Army vs. Navy, or US vs. British pooling arrangements).
- **Historical Era Context:**
  The SEXTANT (Cairo) and EUREKA (Tehran) conferences in late 1943 brought Roosevelt, Churchill, and Stalin together. Stalin’s firm demand for a primary cross-channel operation (OVERLORD) in mid-1944 forced the cancellation of planned Mediterranean amphibious operations and Operation BUCCANEER in the Bay of Bengal.
- **Modern Analytical Insights:**
  The Tehran Conference was the ultimate arbiter of theater resource allocation. Stalin's insistence on a simultaneous major operation in Northern France (OVERLORD) and Southern France (ANVIL) meant that other operations, like BUCCANEER in Southeast Asia, had to surrender their landing craft and troop transport ships. This solidified the 'Europe First' strategic resource split.

### 2. High-Fidelity Simulation Parameters & Real-World Metrics
Generate a comprehensive, structured reference table containing all critical historical constants, coefficients, and operational metrics discussed in this chapter or uncovered by modern scholarship. These will serve as raw database values for our simulator. Specifically, find and include the exact values for:
- Soviet combat division size committed to Operation Bagration to support OVERLORD.
- Number of landing craft released back to the European pool due to the cancellation of BUCCANEER.
For each metric, provide a detailed historical explanation and strategic rationale, explaining how it should be represented in a simulation state (e.g., as a static constant, dynamic capacity cap, or efficiency coefficient).

### 3. Logistical Network Topology (Detailed Mermaid.js Flowchart)
Design a highly detailed, production-grade Mermaid.js diagram showing the logistical network topology, depots, staging areas, ports, convoy routes, and combat nodes of this chapter. You must model capacity limits, congestion delays, and alternative routing:
- **Simulation Focus:** Multi-Objective Coalition Resource Division. Selecting and filtering theater objectives based on total available global resources.
- The diagram must represent the physical flow of supplies (e.g., tons of dry cargo, bulk petroleum, or ammunition) from POEs to final theater depots.

### 4. Mathematical Modeling & Simulation Formulas
Formulate the operational research equations representing the logistics bottleneck or resource allocation problem of this chapter.
- State the model using rigorous LaTeX mathematical formulation (use `$$` for block equations and `$` for inline expressions).
- Define all constants, variables, objective functions, and constraints.
- Provide a detailed explanation of the formulas:
  $$\text{Mathematical Concept: } U_{allied} = \sum_{i} A_i \cdot V_i$$

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
package Logistics.CairoTehran

case class TheaterObjective(name: String, alignmentScore: Double, resourceRequired: Double)

object CoalitionResourceSplit:
  def evaluateAllocations(
    objectives: List[TheaterObjective],
    availableResources: Double
  ): List[TheaterObjective] =
    objectives.filter(_.resourceRequired <= availableResources)
```

### 6. Graduate-Level Operational Analysis
Provide long-form, intellectually challenging, and mathematically grounded answers to the following strategic discussion questions, referencing historical outcomes and physical logistics principles:
- Why did Stalin’s presence at Tehran fundamentally alter the balance of power between the US and British strategic concepts?
- Explain the logistical and strategic implications of canceling Operation BUCCANEER.
