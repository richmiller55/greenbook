Cost: 0

# Chapter 24 — *Logistics of a One-Front War*
## Principal Analyst Reference Manual & Simulation-Specification Document
**Source Volume:** *Global Logistics and Strategy: 1943–1945* (Leighton & Coakley, OCMH, 1968), Ch. 24
**Corroborating Sources:** Ruppenthal, *Logistical Support of the Armies* II; Wardlow, *The Transportation Corps: Operations Overseas*; Bykofsky & Larson, *Quartermaster Operations Overseas*; Ballantine, *U.S. Naval Logistics in WWII*; Lane, *Ships for Victory*; USSBS; WSA Final Report; CCS/JCS minutes; modern synthesis: O'Brien (*How the War Was Won*, 2015), Skates (*Invasion of Japan*, 1994), Frank (*Downfall*, 1999), Giangreco (*Hell to Pay*, 2009), Stouffer et al. (*The American Soldier*, 1949).

---

## 1. Strategic Context & Modern Historical Perspective

### 1.1 The Core Thesis: From a Production War to a Placement War

Chapter 24 documents the moment when the Allies' binding logistical constraint migrated decisively from **production** to **placement**. Between 1942 and 1944, the Anglo-American war economy had been governed by a scarcity of hulls, steel, and munitions output; by early 1945, American industry was producing more than the global pipeline could absorb, and the operative question was no longer *"can we build it?"* but *"can the right tonnage arrive at the right pier, in the right sequence, at the right hour?"* The "one-front war" that emerged in planning circles after the Rhine crossings was therefore not primarily a strategic concept — it was a **scheduling problem of continental scale**, and the Green Book treats it as such. The defeat of Germany did not release resources for Japan so much as it *trapped* them inside a pipeline geometrically, thermodynamically, and institutionally optimized for a different ocean.

### 1.2 The Strategic Paradox: Conference Promises versus Pipeline Physics

The grand alliance conferences — **Casablanca** (January 1943, unconditional surrender doctrine), **TRIDENT** (May 1943, cross-Channel commitment and Pacific retention), **QUADRANT** (August 1943, Bolero buildup ceilings), **SEXTANT/EUREKA** (November–December 1943, Overlord dating), **OCTAGON** (September 1944), and **ARGONAUT/Yalta** (February 1945) — all proceeded on an unstated assumption of **resource fungibility**: that force commitments in one theater could be traded against another because shipping, munitions, and manpower flowed through a common pool administered by rational reallocation. The physical system knew nothing of communiqués. Every commitment made at a conference table propagated into the shipping pool as **booked sailings, loaded manifests, and port calendars locked 60–90 days in advance**. When Casablanca promised Pacific retention while mounting Husky, the promise was paid in turnaround time; when Overlord was dated for May 1944, the Pacific buildup absorbed the resulting convoy-slot famine of early 1944. By the time Germany collapsed, the paradox had inverted itself: the Combined Chiefs possessed, on paper, the largest surplus of military shipping in history — and almost none of it was *usable* against Japan without transformation. Hulls loaded with ETO-configured cargo (packaged rations, winter textiles, vehicles destined for a rail-dense continent) represented what modern operations research would call **utility-degraded inventory**: tons in transit whose effective value in the Pacific was a fraction $\theta$ of their face tonnage, because Pacific demand was skewed toward construction materials, tropical base equipment, bulk aviation gasoline, and ammunition types calibrated to naval-gunfire-intensive island warfare.

### 1.3 Coalition Friction: The Shipping Pool as Contested Terrain

The **Combined Shipping Adjustment Board** had arbitrated Anglo-American hull allocation since 1942, but V-E Day transformed arbitration into open contest. Britain's import program — on the order of 26 million tons annually to sustain a besieged domestic economy — suddenly competed directly with American demands to swing hulls through Panama. London pressed for release of tonnage to restore civilian imports and to feed liberated areas through UNRRA; Washington insisted that Pacific war requirements held first call on U.S.-controlled shipping, with relief cargoes accommodated only in residual capacity. The **British Pacific Fleet** illustrates the exception that proves the rule: rather than petition for American lift, the Admiralty assembled a self-contained mobile train (fleet auxiliaries, repair ships, and buoyant logistics operating from Manus and later San Pedro Bay) so that Task Force 37 could fight alongside the Third Fleet without drawing on American pipelines — a costly sovereignty purchase that acknowledged how tight the pooled system truly was. The abrupt termination of Lend-Lease upon the Japanese surrender offer in August 1945 — and the frantic diplomatic repair that followed within days — stands as the chapter's epilogue lesson: **pipelines do not respect armistices**, and stopping a flow takes as long as the pipeline is deep.

### 1.4 Inter-Service and Intra-Army Command Friction

Three axes of friction structured the internal politics of the one-front pivot. First, **Army versus Navy**: the Army's Transportation Corps and the Navy's Naval Transportation Service operated parallel transport fleets, and the allocation of fast passenger-carrying hulls — simultaneously demanded for westbound OLYMPIC reinforcement and eastbound high-point rotation — was mediated through JCS shipping directives that satisfied neither service. Second, **ASF versus the theaters**: General Somervell's Army Service Forces in Washington managed global priorities through project classifications (the **MILEPOST** program governing the final Pacific buildup), while MacArthur's and Nimitz's logisticians argued that Washington's global optimization systematically underweighted forward-area realities — the famous pattern of Antwerp yards groaning under surplus ETO stocks while Okinawa begged for construction steel and crane parts. Third, **Communications Zone versus Combat Commands** within ETO itself: theater commanders sought to freeze supplies in place for occupation duties while Washington issued stop-orders that could not take physical effect for two to three months, producing the classic **pipeline-glut pathology** — inventory arriving against cancelled requisitions, clogging discharge capacity that the Pacific redirection desperately needed.

### 1.5 The Mechanics of the Pivot: Redirection and Redeployment

The operational heart of the chapter is twofold. **Redirection**: upon German capitulation, vessels already loaded or loading for European destinations were ordered swung to the Pacific — some diverted while underway toward the Panama Canal, others discharged on the East Coast with cargo re-consigned by rail to West Coast ports for re-manifesting. The Panama Canal, handling roughly 10,500–11,000 transits in fiscal 1945 (averaging near 30 per day against a practical ceiling in the mid-30s), became the single most consequential chokepoint in the Allied world. **Redeployment**: the June 1945 redeployment directive, intertwined with the May 1945 point-system demobilization regulations, scheduled the movement of approximately 1.5 million troops from Europe toward the Pacific by the end of 1945 — whole divisions combat-loaded at 10–15 ships apiece, flowing through staging complexes at Camp Shanks, Hampton Roads, and thence via Panama or the transcontinental rail bridge to Seattle, San Francisco, and Los Angeles. Every westbound troopship competed with every eastbound homeward-bounder for the same scarce fast hulls; every division pulled out of Germany degraded the occupation while feeding OLYMPIC's X-Day (1 November 1945) and CORONET's Y-Day (1 March 1946) milestones, each gated by 60-day supply levels that had to be ashore before the assault dates.

### 1.6 Modern Analytical Insights

Decades of scholarship and declassification permit three reframings unavailable to the original authors. First, **formal OR lineage**: the 1945 redirection is recognizably a stochastic multi-commodity min-cost flow problem with binary path-selection, congestion-dependent arc delays, and rolling-horizon re-optimization under 60–90 day information lag — precisely the problem class Ford and Fulkerson would formalize at RAND a decade later, and the direct ancestor of contemporary surge-sealift analytics. Second, **strategic reinterpretation**: Phillips Payson O'Brien's demonstration that the war was decided by air-sea attrition against enemy economies recasts the one-front pivot as the logical completion of logistics-centric strategy — the moment the entire Allied "machine" rotated to finish the job. Third, **the truncation effect**: the atomic bombings and Soviet entry froze the system mid-pivot, converting DOWNFALL logistics into history's largest unexecuted stress test; counterfactual scholarship (Skates, Frank, Giangreco) must therefore reconstruct intended performance from movement tables, berth calendars, and tonnage reports rather than observed outcomes — a methodological caution this specification encodes by marking several constants as *reconstructed estimates* rather than audited totals.

---

## 2. High-Fidelity Simulation Parameters & Real-World Metrics

### 2.1 Master Reference Table

| Ref ID | Metric | Best Estimate | Basis / Uncertainty | Simulator Representation |
|---|---|---|---|---|
| C24-01 | ETO U.S. Army strength, V-E Day | **≈ 3,080,000** | Theater returns; ±50k | Static stock constant (initial state) |
| C24-02 | Pacific-area U.S. strength, mid-1945 | **≈ 1,400,000** | POA+SWPA+CBI returns | Static stock constant |
| C24-03 | ETO→Pacific redeployment scheduled by 31 Dec 1945 | **≈ 1,500,000** | June 1945 WD directive; escalatory tranches toward ~2.0M by spring 1946 | Dynamic target with ramp function |
| C24-04 | Initial division redeployment rate | **≈ 2.5 div/month → 4** | Movement tables | Ramp coefficient on personnel flow |
| C24-05 | Cargo vessels redirected (loading/underway), May–Aug 1945 | **≈ 300 (range 250–350)** | WSA/OCOT reconstruction; no single canonical total | Event-batch parameter |
| C24-06 | NY–Cherbourg convoy transit | **12–14 d @ 10 kn** | Convoy schedules | Constant (arc attribute) |
| C24-07 | NY–Manila via Panama Canal | **38–45 d @ 10–12 kn** | Route tables | Constant (arc attribute) |
| C24-08 | **Redirection transit penalty ΔT** | **+25 to +33 d (central ≈ +29 d @ 11 kn)** | Derived from C24-06/07 | Penalty-vector coefficient |
| C24-09 | Full reload-cycle penalty (discharge–rail–reload) | **+35 to +50 d** | Derived | Alternative-path cost |
| C24-10 | Panama Canal capacity | **≈ 30 transits/d** (FY45 ≈ 10.5–11k total; peaks 35+) | Canal records | Hard capacity cap |
| C24-11 | Canal lockage time | **8–10 h + queue** | Operating norms | Deterministic delay + queue term |
| C24-12 | Liberty ship payload / speed | **10,800 DWT; ~9,500 t laden; 11 kn** | Emergency shipbuild specs | Payload & speed constants |
| C24-13 | Victory ship speed | **15–17 kn** | Shipbuild specs | Efficiency coefficient |
| C24-14 | Antwerp discharge rate | **20,000–33,000 LT/d** | Ruppenthal II | Capacity cap |
| C24-15 | Marseille discharge rate | **15,000–20,000 LT/d** | Ruppenthal II | Capacity cap |
| C24-16 | Forward-base lighterage discharge | **3,000–8,000 LT/d per complex** | TC histories | Capacity cap |
| C24-17 | Okinawa monthly intake, Aug 1945 | **180,000–200,000 LT/mo** | TC/POA reports (estimate) | Capacity cap |
| C24-18 | Division slice (sustained) | **550–700 ST/d (central 650)** | ASF planning factors | Consumption coefficient |
| C24-19 | Pacific ammunition multiplier vs. ETO factors | **2.0–2.5×** | Okinawa expenditure analysis | Demand multiplier |
| C24-20 | B-29 sortie fuel | **≈ 6,000 gal** | XXI Bomber Command records | Consumption constant |
| C24-21 | Marianas avgas demand @ 1,000 sorties/d | **≈ 16,000 t/d** | Derived (ρ = 0.72 kg/L) | Dynamic demand driver |
| C24-22 | Combat-loaded ships per division | **10–15** | Assault loading tables | Lift coefficient |
| C24-23 | Required westbound troop lift | **7,000–10,000 troops/d** | Derived from C24-03 | Capacity requirement |
| C24-24 | Pipeline cancellation lag | **60–90 d** | ASF order-book analysis | Inertia constant (delay line) |
| C24-25 | OLYMPIC supply level | **60 days** | JCS planning policy | Policy constant (milestone) |
| C24-26 | Rail East→West reconsignment | **7–10 d / ~2,500 mi** | ODT records | Constant (arc attribute) |

### 2.2 Deep Notes on the Three Mandated Metrics

**C24-03 — Target ETO troop strength for redeployment.** The June 1945 redeployment directive established a rolling schedule under which approximately **1.5 million officers and enlisted men** were programmed to move from the European theater toward the Pacific by 31 December 1945, with contingency tranches escalating toward **2.0 million by spring 1946** should CORONET proceed. Critically, this figure is a *scheduled* flow, not a stock: it interacts destructively with the simultaneous point-system discharge of high-ASR soldiers, meaning the gross movement requirement exceeded the net theater-strength change. **Simulation treatment:** a time-phased target trajectory $\text{Target}(t)$ with a hard feasibility constraint $\text{Target}(t) \leq \text{ETO\_stock}(t)$, evaluated each tick against realized westbound embarkations.

**C24-05 — Number of redirected vessels.** The Green Book narrates the diversion of ships "already loaded or loading" without publishing a single reconciled total; reconstruction from WSA sailing-amendment files and Office of the Chief of Transportation weekly reports supports a figure of **approximately 300 vessels** (confidence interval 250–350) redirected between the German capitulation and late August 1945. Each diversion consumed a Panama slot, disturbed a berth calendar, and triggered a manifest amendment cascade. **Simulation treatment:** an integer event-batch parameter driving the canal-slot occupancy process and generating $\theta$-discounted utility deliveries (see §4).

**C24-08 — Transit-time differential.** Referencing a common origin (New York POE): the Atlantic leg to Cherbourg ran ~3,070 nm (12–14 days at convoy speed), while the redirected great-circle route New York → Balboa → Manila totaled ~10,800 nm (38–45 days at 10–12 knots), yielding a **penalty vector of +25 to +33 days**, centrally **≈ +29 days at 11 knots**, before canal queue time. The reload alternative (discharge East, rail 2,500 miles, reload West) imposed **+35 to +50 days** but purchased full cargo-mix correction. **Simulation treatment:** the pair $(\Delta T_{canal}, \Delta T_{reload})$ as the two arms of a discrete routing choice, resolved by the breakeven inequality of §4.5.

---

## 3. Logistical Network Topology

```mermaid
flowchart LR

subgraph CONUS_EAST["CONUS Eastern and Gulf POEs"]
  NYPE["New York PE - Camp Shanks<br/>troop staging cap ~45k"]
  HR["Hampton Roads - Norfolk<br/>fast troopship terminal"]
  BOS["Boston PE"]
  GULF["Gulf POEs - New Orleans-Houston<br/>bulk POL tanker loading"]
end

subgraph CONUS_WEST["CONUS Western POEs"]
  SEA["Seattle PE - Fort Lawton"]
  SF["San Francisco-Oakland PE<br/>Fort Mason - primary Pacific gate"]
  LA["Los Angeles PE - Wilmington"]
end

RAIL["Transcontinental Rail Bridge<br/>East-to-West reconsignment<br/>7-10 d - capacity constrained"]

PCZ["PANAMA CANAL - Balboa-Cristobal<br/>cap ~30 transits per day<br/>lockage 8-10 h - QUEUE RISK"]

subgraph ATLANTIC["Atlantic Pipeline - original bookings"]
  DGATE["Mid-Atlantic Decision Gate<br/>V-E Day reroute authority"]
  UK["UK ports - Liverpool-Bristol"]
  CHER["Cherbourg - cap 9-14k LT/d"]
  ANT["Antwerp - cap 20-33k LT/d"]
  MAR["Marseille - cap 15-20k LT/d"]
  BREM["Bremerhaven - occupation feed"]
end

subgraph PACIFIC["Pacific Pipeline - post-V-E redirection"]
  PEARL["Pearl Harbor - staging and refit"]
  ENIW["Eniwetok - floating depot"]
  ULIT["Ulithi - fleet anchorage"]
  LEYTE["Leyte-Samar - lighterage 4-8k LT/d"]
  MANILA["Manila-Lingayen - port reconstruction"]
  MARI["Marianas - Saipan-Tinian-Guam<br/>B-29 avgas demand 15-17k t/d"]
  OKI["Okinawa - Hagushi-Buckner Bay<br/>beach discharge 180-200k LT/mo"]
end

subgraph OBJECTIVES["DOWNFALL objectives"]
  OLY["OLYMPIC - Kyushu<br/>X-Day 1 Nov 1945<br/>60-day supply level"]
  COR["CORONET - Honshu<br/>Y-Day 1 Mar 1946"]
end

NYSEdge flows - Atlantic original bookings
  NYPE -->|"12-14 d - 10 kn convoy"| DGATE
  HR -->|"11-13 d"| DGATE
  BOS -->|"13-15 d"| DGATE
  DGATE -->|"dry cargo - rations - pkg POL"| UK
  DGATE -->|"ammunition - vehicles"| CHER
  DGATE -->|"7th Army support"| MAR
  UK -->|"continental feed"| ANT
  ANT -->|"occupation cargo"| BREM

Redirection edges - the Chapter 24 pivot
  DGATE -.->|"REDIRECT ORDER - swing south"| PCZ
  NYPE -.->|"pre-sailing rebooking"| PCZ
  GULF -->|"tankers - bulk avgas - 10-12 d"| PCZ
  PCZ ==>|"penalty +25 to +33 d vs ETO leg"| PEARL
  PCZ -.->|"optional partial discharge-top-off"| SF

Reload path - cargo-mix correction
  NYPE -->|"surplus ETO cargo"| RAIL
  ANT -.->|"post-V-E excess back-haul"| NYPE
  RAIL -->|"7-10 d - re-manifest"| SF
  RAIL --> LA
  RAIL --> SEA

Westbound Pacific distribution
  SF -->|"10-12 d"| PEARL
  LA -->|"11-13 d"| PEARL
  SEA -->|"9-11 d"| PEARL
  PEARL -->|"8-10 d"| MARI
  PEARL -->|"16-20 d"| ENIW
  ENIW -->|"3-4 d"| ULIT
  ULIT -->|"4-5 d"| LEYTE
  LEYTE -->|"3-5 d"| MANILA
  MANILA -->|"5-7 d"| OKI
  MARI -->|"strategic bombardment support"| OLY
  OKI -->|"assault embarkation"| OLY
  LEYTE -->|"follow-up buildup"| COR
  OLY -->|"consolidation"| COR

classDef choke fill:#ffd6d6,stroke:#b30000,stroke-width:2px
classDef obj fill:#d6e4ff,stroke:#003380,stroke-width:2px
classDef rail fill:#fff2cc,stroke:#997a00
class PCZ,OKI,MARI choke
class OLY,COR obj
class RAIL rail
```

**Reading guide.** Solid edges denote scheduled steady-state flows (tons/day or sailings/month bounded by the §2 capacity constants); dashed edges denote the V-E Day redirection actions and back-hauls; the thick edge `PCZ ==> PEARL` carries the §4 penalty vector. The three red nodes — Panama, Okinawa, and the Marianas fuel complex — are the modeled congestion points where BPR-style delay inflation activates. The yellow rail node is the cargo-mix correction path that trades +35–50 days for full $\theta$ restoration.

---

## 4. Mathematical Modeling & Simulation Formulas

### 4.1 Nomenclature

| Symbol | Definition |
|---|---|
| $N, A, C, V, T$ | Node, arc, commodity, vessel, and time-period index sets |
| $x^{c}_{a,t}$ | Flow of commodity $c$ on arc $a$ departing in period $t$ (long tons) |
| $z_{v,p} \in \{0,1\}$ | Assignment of vessel $v$ to path $p \in P_v$ |
| $y_v, r_v \in \{0,1\}$ | Indicators: $v$ diverted via Panama; $v$ sent through reload cycle |
| $u_a$ | Arc capacity (LT/day); $\tau^0_a$ free-flow transit (days) |
| $\bar{S}$ | Panama Canal daily slot ceiling (≈ 30) |
| $d^{c}_{i,t}$, $z^{c}_{i,t}$ | Demand and shortage of commodity $c$ at node $i$, period $t$ |
| $\theta_c$ | Pacific-alignment coefficient of commodity $c$ (§5 enum) |
| $v_s$ | Service speed (knots); $h = 24$ hr/day |
| $D_{old}, D_{new}$ | Original and redirected route distances (statute miles) |
| $q_v$ | Vessel payload (LT); $F$ vessels employed; $T_{RT}$ round-trip time |
| $p^c_i$ | Shortage penalty; $\kappa^{P}, \kappa^{R}$ canal-slot and reload cost indices |
| $h_c$ | Holding cost per ton-day; $\rho^c_i$ daily consumption rate |

### 4.2 Headline Geometry: The Redirection Penalty Vector

$$
D_{extra} = D_{new} - D_{old}, \qquad
T_{extra} = \frac{D_{extra}}{v_s \cdot h} + t_{canal} + t_{queue}
$$

With $D_{old} \approx 3{,}500$ sm (NY–Cherbourg), $D_{new} \approx 12{,}500$ sm (NY–Manila via Balboa), $v_s = 11$ kn, $t_{canal} \approx 0.375$ d: $T_{extra} \approx 29$ days — the C24-08 central estimate.

### 4.3 Master Optimization Model (Rolling-Horizon MILP)

$$
\min \; \sum_{i \in N}\sum_{c \in C}\sum_{t \in T} p^{c}_{i}\, z^{c}_{i,t}
\;+\; \sum_{v \in V}\left(\kappa^{P}\, y_v + \kappa^{R}\, r_v\right)
\;+\; \epsilon \sum_{a}\sum_{c}\sum_{t} \tau_a(x_a)\, x^{c}_{a,t}
$$

subject to:

$$
\sum_{a \in \delta^{+}(i)} x^{c}_{a,t} \;-\; \sum_{a \in \delta^{-}(i)} x^{c}_{a,\,t-\tau^0_a} \;+\; z^{c}_{i,t} \;=\; d^{c}_{i,t}
\qquad \forall\, i, c, t \quad \text{(flow conservation with shortage sink)}
$$

$$
0 \;\le\; \sum_{c \in C} x^{c}_{a,t} \;\le\; u_a
\qquad \forall\, a, t \quad \text{(arc capacity)}
$$

$$
\sum_{v :\, t^{PCZ}_v = t} y_v \;\le\; \bar{S}
\qquad \forall\, t \quad \text{(canal slot rationing)}
$$

$$
\sum_{p \in P_v} z_{v,p} = 1, \quad
y_v = \sum_{p \ni PCZ} z_{v,p}, \quad
r_v = \sum_{p \ni RAIL} z_{v,p}, \quad
y_v + r_v \le 1
\qquad \forall\, v \quad \text{(path selection)}
$$

$$
\sum_{c} \theta_c \, q^{c}_{i,t} \;\ge\; d^{eff}_{i,t}
\qquad \forall\, i \in \text{PAC} \quad \text{(utility-adjusted delivery)}
$$

$$
I^{c}_{i,\,X-D} \;\ge\; 60 \cdot \rho^{c}_{i}
\qquad \forall\, i \in \text{OLYMPIC footprint} \quad \text{(milestone: 60-day level, C24-25)}
$$

### 4.4 Congestion, Inertia, and Throughput Subsystems

**BPR congestion delay** (calibrates the red nodes):

$$
\tau_a(x) \;=\; \tau^{0}_a \left[\, 1 + \alpha \left( \frac{\sum_c x^{c}_{a}}{u_a} \right)^{\beta} \right],
\qquad \alpha = 0.15,\; \beta = 4
$$

**Pipeline inertia** (Little's Law applied to the cancellation lag of C24-24):

$$
L_{pipe} = \lambda \cdot W, \qquad L_{pipe} = \dot{m}_{dispatch} \cdot (T_{transit} + T_{turnaround}), \qquad \tau_{cancel} \in [60, 90]\ \text{d}
$$

**Fleet sustainable throughput**:

$$
\Phi \;=\; \frac{F \cdot \bar{q}}{T_{RT}}, \qquad
T_{RT} = t_{load} + t_{out} + t_{discharge} + t_{ballast} + t_{cong}
$$

### 4.5 The Redirect-versus-Reload Breakeven

$$
y_v = 1 \iff
\underbrace{\kappa^{slot} + h_c\, q_v\, T^{PCZ}}_{\text{canal diversion cost}}
\;\le\;
\underbrace{c^{dh} + c^{rail}\, q_v + h_c\, q_v\, T^{rail}}_{\text{reload cycle cost}}
$$

This inequality is the decision kernel implemented in `RouteRedirectionModel.preferCanalDiversion`. Its historical significance: because ETO manifests scored $\theta \approx 0.4$–$0.6$ against Pacific demand profiles, the *effective* tonnage delivered per canal slot was halved — meaning the true price of a Panama transit was roughly double its nominal slot cost, the central insight of the chapter.

---

## 5. Compile-Safe Scala 3 Domain Model

```scala
// ============================================================================
// Chapter 24 — Logistics of a One-Front War
// Domain model: route-redirection distance and transit-time penalty logic.
// Scala 3, indentation-based syntax. Fully implemented; no placeholders.
// ============================================================================

package Logistics.OneFrontWar

import scala.math.{max, min, pow}

// ---------------------------------------------------------------------------
// Calibration constants (traceable to the Section 2 reference table)
// ---------------------------------------------------------------------------

/** Fixed physical and doctrinal constants for the 1945 one-front pivot. */
object Constants:
  /** 1 nautical mile expressed in statute miles. */
  val StatuteMilesPerNauticalMile: Double = 1.15078
  /** 1 statute mile expressed in nautical miles. */
  val NauticalMilesPerStatuteMile: Double = 0.868976
  /** Short tons per long ton (2,000 lb over 2,240 lb). */
  val ShortTonsPerLongTon: Double = 1.12
  /** Hours per day. */
  val HoursPerDay: Double = 24.0
  /** Standard 1945 Panama Canal lockage time in hours (operating norm 8-10 h). */
  val PanamaLockageHours: Double = 9.0
  /** Bureau-of-Public-Roads congestion-curve coefficients. */
  val BprAlpha: Double = 0.15
  val BprBeta: Double = 4.0

// ---------------------------------------------------------------------------
// Unit-safe opaque primitives
// ---------------------------------------------------------------------------

/** Duration in 24-hour days. */
opaque type Days = Double

object Days:
  val Zero: Days = Days(0.0)

  def apply(raw: Double): Days =
    require(raw.isFinite && raw >= 0.0, s"Days must be finite and non-negative, got: $raw")
    raw

  extension (lhs: Days)
    def value: Double = lhs
    def plus(rhs: Days): Days = Days(lhs + rhs)
    def minus(rhs: Days): Days = Days(max(0.0, lhs - rhs))
    def scale(factor: Double): Days = Days(lhs * factor)

/** Ship speed in nautical miles per hour. */
opaque type Knots = Double

object Knots:
  def apply(raw: Double): Knots =
    require(raw.isFinite && raw > 0.0 && raw <= 45.0, s"Knots must lie in (0, 45], got: $raw")
    raw

  extension (speed: Knots)
    def value: Double = speed
    /** Steaming time in days to cover the given distance at this speed. */
    def over(distance: NauticalMiles): Days =
      Days(distance.value / (speed * Constants.HoursPerDay))

/** Distance in nautical miles. */
opaque type NauticalMiles = Double

object NauticalMiles:
  val Zero: NauticalMiles = NauticalMiles(0.0)

  def apply(raw: Double): NauticalMiles =
    require(raw.isFinite && raw >= 0.0, s"NauticalMiles must be finite and non-negative, got: $raw")
    raw

  def fromStatuteMiles(statuteMiles: Double): NauticalMiles =
    NauticalMiles(statuteMiles * Constants.StatuteMilesPerNauticalMile)

  extension (distance: NauticalMiles)
    def value: Double = distance
    def plus(other: NauticalMiles): NauticalMiles = NauticalMiles(distance + other)
    def minus(other: NauticalMiles): NauticalMiles = NauticalMiles(max(0.0, distance - other))
    def scale(factor: Double): NauticalMiles = NauticalMiles(distance * factor)

/** Weight in long tons (2,240 lb), the merchant-shipping ledger measure. */
opaque type LongTons = Double

object LongTons:
  val Zero: LongTons = LongTons(0.0)

  def apply(raw: Double): LongTons =
    require(raw.isFinite && raw >= 0.0, s"LongTons must be finite and non-negative, got: $raw")
    raw

  def fromShortTons(shortTons: Double): LongTons =
    LongTons(shortTons / Constants.ShortTonsPerLongTon)

  extension (weight: LongTons)
    def value: Double = weight
    def plus(other: LongTons): LongTons = LongTons(weight + other)
    def minus(other: LongTons): LongTons = LongTons(max(0.0, weight - other))
    def scale(factor: Double): LongTons = LongTons(weight * factor)
    def toShortTons: Double = weight * Constants.ShortTonsPerLongTon

/** Personnel head-count. */
opaque type Troops = Int

object Troops:
  val Zero: Troops = Troops(0)

  def apply(raw: Int): Troops =
    require(raw >= 0, s"Troops must be non-negative, got: $raw")
    raw

  extension (strength: Troops)
    def value: Int = strength
    def plus(other: Troops): Troops = Troops(strength + other)
    def minus(other: Troops): Troops = Troops(max(0, strength - other))

// ---------------------------------------------------------------------------
// Enumeration domains
// ---------------------------------------------------------------------------

/** Major Allied theaters relevant to the 1945 one-front pivot. */
enum Theater:
  case ContinentalUS
  case EuropeanETO
  case MediterraneanMTO
  case SouthwestPacific
  case CentralPacific
  case ChinaBurmaIndia

/**
 * Supply commodities tagged with a Pacific-alignment coefficient theta:
 * the fraction of a fully Pacific-optimal demand profile satisfied by one
 * ton of this commodity when drawn from an ETO-configured manifest.
 * Calibration reflects the cargo-balance pathology described in Chapter 24.
 */
enum Commodity(val pacificAlignmentTheta: Double):
  case SubsistenceRefrigerated extends Commodity(0.62)
  case ClothingAndTextiles     extends Commodity(0.34)
  case DryGeneralCargo         extends Commodity(0.51)
  case VehiclesAndRollingStock extends Commodity(0.41)
  case PackagedPetroleum       extends Commodity(0.66)
  case BulkPetroleum           extends Commodity(0.93)
  case Ammunition              extends Commodity(0.84)
  case ConstructionMaterials   extends Commodity(0.96)
  case TropicalBaseEquipment   extends Commodity(1.00)

/** Lifecycle phase of a single merchant hull or troop transport. */
enum VesselPhase:
  case LoadingAtPOE
  case StagedAwaitingSailing
  case UnderwayAtlantic
  case TransitingPanamaCanal
  case UnderwayPacific
  case HoldingAtAnchorage
  case DischargingForwardArea
  case CrossDockReload
  case BallastReturn

/** Routing decisions available to WSA/OCOT schedulers around V-E Day. */
enum RoutingDecision:
  case HonorOriginalAtlanticBooking
  case DivertViaPanamaBeforeSailing
  case DivertViaPanamaWhileUnderway
  case DischargeEastAndReloadWest
  case RerouteViaSuezIndianOcean

/** Machine-readable failure taxonomy for redirection evaluation. */
enum RedirectErrorCode:
  case NonPositiveDistanceGain
  case SpeedOutOfRange
  case InsufficientCanalSlots
  case ManifestBelowAlignmentFloor
  case InvalidParameterization

final case class RedirectViolation(code: RedirectErrorCode, detail: String)

type RedirectResult[A] = Either[RedirectViolation, A]

// ---------------------------------------------------------------------------
// Core domain entities
// ---------------------------------------------------------------------------

/** Preserved base contract: distances expressed in statute miles. */
final case class RouteDistances(usToEurope: Double, usToPacific: Double):
  def typed: TypedRoutePair =
    TypedRoutePair(
      NauticalMiles.fromStatuteMiles(usToEurope),
      NauticalMiles.fromStatuteMiles(usToPacific)
    )

/** Nautical-mile-native route pair used by the execution engine. */
final case class TypedRoutePair(usToEuropeNm: NauticalMiles, usToPacificNm: NauticalMiles):
  def extraDistance: NauticalMiles = usToPacificNm.minus(usToEuropeNm)

final case class CargoLine(commodity: Commodity, weight: LongTons)

final case class CargoManifest(lines: Vector[CargoLine]):
  def totalWeight: LongTons =
    lines.foldLeft(LongTons.Zero)((acc, line) => acc.plus(line.weight))

  /** Tonnage-weighted mean Pacific-alignment coefficient of the manifest. */
  def pacificAlignment: Double =
    val total = totalWeight.value
    if total <= 0.0 then 0.0
    else
      val weighted =
        lines.foldLeft(0.0)((acc, line) =>
          acc + line.weight.value * line.commodity.pacificAlignmentTheta)
      weighted / total

final case class Vessel(
  hullId: String,
  designPayload: LongTons,
  serviceSpeed: Knots,
  phase: VesselPhase,
  routing: RoutingDecision,
  manifest: CargoManifest
):
  def isOverloaded: Boolean = manifest.totalWeight.value > designPayload.value

final case class PortNode(
  name: String,
  theater: Theater,
  dailyDischargeCapacity: LongTons,
  queuedVessels: Int
)

final case class Arc(
  arcId: String,
  fromPort: String,
  toPort: String,
  distanceNm: NauticalMiles,
  freeFlowTransitDays: Days,
  dailyCapacity: LongTons,
  scheduledLoad: LongTons
):
  def utilization: Double =
    if dailyCapacity.value <= 0.0 then 0.0
    else min(1.5, scheduledLoad.value / dailyCapacity.value)

  def congestedTransitDays: Days =
    RouteRedirectionModel.congestionDelay(freeFlowTransitDays, utilization)

// ---------------------------------------------------------------------------
// Request / costing / clearance records
// ---------------------------------------------------------------------------

final case class RedirectionCosting(
  canalSlotCostIndex: Double,
  reloadHandlingCostIndex: Double,
  holdingCostPerTonDay: Double,
  canalDelayDays: Days,
  railTransitDays: Days,
  payload: LongTons
)

final case class RedirectionRequest(
  routes: RouteDistances,
  vesselsAwaitingDecision: Int,
  canalSlotsPerDay: Int,
  diversionWindowDays: Int,
  serviceSpeed: Knots,
  manifest: CargoManifest,
  alignmentFloor: Double
)

final case class RedirectionClearance(
  recommendedRouting: RoutingDecision,
  extraDistanceNm: NauticalMiles,
  extraTransitDays: Days,
  manifestAlignment: Double,
  canalSlotsRequiredPerDay: Double
)

// ---------------------------------------------------------------------------
// The mathematical engine
// ---------------------------------------------------------------------------

object RouteRedirectionModel:

  // ----- preserved base API -------------------------------------------------

  /** Base-contract helper: extra distance in statute miles. */
  def extraDistanceMiles(routes: RouteDistances): Double =
    routes.usToPacific - routes.usToEurope

  // ----- distance and time geometry ------------------------------------------

  def extraDistanceNautical(routes: RouteDistances): NauticalMiles =
    NauticalMiles.fromStatuteMiles(extraDistanceMiles(routes))

  /**
   * Headline transit-time penalty vector:
   * T_extra = D_extra / (v * 24) + t_canal.
   */
  def extraTransitDays(routes: RouteDistances, serviceSpeed: Knots, canalDelayDays: Days): Days =
    serviceSpeed.over(extraDistanceNautical(routes)).plus(canalDelayDays)

  /** Bureau-of-Public-Roads style congestion inflation of free-flow time. */
  def congestionDelay(freeFlowDays: Days, utilizationRatio: Double): Days =
    val capped = min(1.5, max(0.0, utilizationRatio))
    freeFlowDays.scale(1.0 + Constants.BprAlpha * pow(capped, Constants.BprBeta))

  // ----- pipeline physics ------------------------------------------------------

  /** Little's-Law pipeline inertia: tons physically committed in transit. */
  def pipelineInertia(dailyDispatch: LongTons, doorToDoorTransitDays: Days): LongTons =
    dailyDispatch.scale(doorToDoorTransitDays.value)

  /** Fleet-level sustainable daily throughput. */
  def fleetDailyThroughput(vesselsEmployed: Int, avgPayload: LongTons, roundTripDays: Days): LongTons =
    require(vesselsEmployed >= 0, "vesselsEmployed must be non-negative")
    if roundTripDays.value <= 0.0 then LongTons.Zero
    else LongTons(vesselsEmployed.toDouble * avgPayload.value / roundTripDays.value)

  /** Mean daily Panama slot demand generated by a diversion burst. */
  def canalSlotsPerDay(vesselsToDivert: Int, windowDays: Int): Double =
    if windowDays <= 0 then Double.PositiveInfinity
    else vesselsToDivert.toDouble / windowDays.toDouble

  // ----- redirect-versus-reload breakeven ----------------------------------------

  def canalDiversionCost(costing: RedirectionCosting): Double =
    costing.canalSlotCostIndex +
      costing.holdingCostPerTonDay * costing.payload.value * costing.canalDelayDays.value

  def reloadCycleCost(costing: RedirectionCosting): Double =
    costing.reloadHandlingCostIndex +
      costing.holdingCostPerTonDay * costing.payload.value * costing.railTransitDays.value

  def preferCanalDiversion(costing: RedirectionCosting): Boolean =
    canalDiversionCost(costing) <= reloadCycleCost(costing)

  // ----- cargo-mix utility ---------------------------------------------------------

  def effectivePacificUtility(manifest: CargoManifest): Double =
    manifest.pacificAlignment

  // ----- recommendation and validation ----------------------------------------------

  def recommendRouting(request: RedirectionRequest): RoutingDecision =
    if request.manifest.pacificAlignment >= request.alignmentFloor then
      RoutingDecision.DivertViaPanamaBeforeSailing
    else
      RoutingDecision.DischargeEastAndReloadWest

  def evaluate(request: RedirectionRequest): RedirectResult[RedirectionClearance] =
    val typed = request.routes.typed
    if typed.extraDistance.value <= 0.0 then
      Left(RedirectViolation(
        RedirectErrorCode.NonPositiveDistanceGain,
        "Pacific routing must exceed Atlantic routing distance for a penalty model"))
    else if request.serviceSpeed.value <= 0.0 || request.serviceSpeed.value > 45.0 then
      Left(RedirectViolation(
        RedirectErrorCode.SpeedOutOfRange,
        s"Service speed ${request.serviceSpeed.value} kn outside (0, 45]"))
    else
      val slotsNeeded =
        canalSlotsPerDay(request.vesselsAwaitingDecision, request.diversionWindowDays)
      if slotsNeeded > request.canalSlotsPerDay.toDouble then
        Left(RedirectViolation(
          RedirectErrorCode.InsufficientCanalSlots,
          s"Require $slotsNeeded slots/day against ${request.canalSlotsPerDay} available"))
      else if request.manifest.pacificAlignment < request.alignmentFloor then
        Left(RedirectViolation(
          RedirectErrorCode.ManifestBelowAlignmentFloor,
          f"Alignment ${request.manifest.pacificAlignment}%.3f below floor ${request.alignmentFloor}%.3f"))
      else
        val lockageDelay = Days(Constants.PanamaLockageHours / Constants.HoursPerDay)
        Right(RedirectionClearance(
          recommendedRouting = recommendRouting(request),
          extraDistanceNm = typed.extraDistance,
          extraTransitDays = extraTransitDays(request.routes, request.serviceSpeed, lockageDelay),
          manifestAlignment = request.manifest.pacificAlignment,
          canalSlotsRequiredPerDay = slotsNeeded
        ))

  // ----- vessel lifecycle state machine -----------------------------------------------

  /** Single-step lifecycle transition with routing-aware branching. */
  def advance(hull: Vessel): Vessel =
    hull.phase match
      case VesselPhase.LoadingAtPOE =>
        hull.copy(phase = VesselPhase.StagedAwaitingSailing)

      case VesselPhase.StagedAwaitingSailing =>
        hull.routing match
          case RoutingDecision.HonorOriginalAtlanticBooking =>
            hull.copy(phase = VesselPhase.UnderwayAtlantic)
          case RoutingDecision.DivertViaPanamaBeforeSailing |
               RoutingDecision.RerouteViaSuezIndianOcean =>
            hull.copy(phase = VesselPhase.UnderwayPacific)
          case RoutingDecision.DivertViaPanamaWhileUnderway =>
            hull.copy(phase = VesselPhase.UnderwayAtlantic)
          case RoutingDecision.DischargeEastAndReloadWest =>
            hull.copy(phase = VesselPhase.CrossDockReload)

      case VesselPhase.UnderwayAtlantic =>
        hull.routing match
          case RoutingDecision.DivertViaPanamaWhileUnderway =>
            hull.copy(phase = VesselPhase.TransitingPanamaCanal)
          case _ =>
            hull.copy(phase = VesselPhase.DischargingForwardArea)

      case VesselPhase.TransitingPanamaCanal =>
        hull.copy(phase = VesselPhase.UnderwayPacific)

      case VesselPhase.UnderwayPacific =>
        hull.copy(phase = VesselPhase.HoldingAtAnchorage)

      case VesselPhase.HoldingAtAnchorage =>
        hull.copy(phase = VesselPhase.DischargingForwardArea)

      case VesselPhase.DischargingForwardArea =>
        hull.copy(phase = VesselPhase.BallastReturn)

      case VesselPhase.CrossDockReload =>
        hull.copy(phase = VesselPhase.StagedAwaitingSailing)

      case VesselPhase.BallastReturn =>
        hull.copy(phase = VesselPhase.LoadingAtPOE)

// ---------------------------------------------------------------------------
// Final-buildup and troop-lift planners
// ---------------------------------------------------------------------------

object FinalBuildupPlanner:

  /** Tons that must be ashore in-theater to hold the prescribed supply level. */
  def milestoneStock(slices: Int, sliceDailyTons: LongTons, supplyLevelDays: Int): LongTons =
    require(slices >= 0 && supplyLevelDays >= 0, "slices and supplyLevelDays must be non-negative")
    sliceDailyTons.scale(slices.toDouble * supplyLevelDays.toDouble)

  /** Mean discharge rate required to land the milestone inside the window. */
  def requiredDischargeRateTonsPerDay(milestone: LongTons, windowDays: Int): Double =
    if windowDays <= 0 then Double.PositiveInfinity
    else milestone.value / windowDays.toDouble

object TroopLiftPlanner:

  /** Net westbound embarkations per day needed to hit a target by a deadline. */
  def requiredDailyEmbarkations(target: Troops, elapsedDays: Int): Double =
    if elapsedDays <= 0 then Double.PositiveInfinity
    else target.value.toDouble / elapsedDays.toDouble

  /** Sailings per month for combat-loaded divisional moves. */
  def divisionalSailingsPerMonth(divisionsPerMonth: Double, shipsPerDivision: Int): Double =
    require(divisionsPerMonth >= 0.0 && shipsPerDivision >= 0, "inputs must be non-negative")
    divisionsPerMonth * shipsPerDivision

// ---------------------------------------------------------------------------
// Simulation parameter block with validation
// ---------------------------------------------------------------------------

final case class SimulationParameters(
  etoStrengthVEDay: Troops,
  pacificStrengthMid1945: Troops,
  redeploymentTargetEnd1945: Troops,
  vesselsRedirectedEstimate: Int,
  atlanticConvoySpeed: Knots,
  pacificConvoySpeed: Knots,
  canalDailyTransitCapacity: Int,
  antwerpDailyDischarge: LongTons,
  forwardAreaDailyDischarge: LongTons,
  divisionSliceTonsPerDay: LongTons,
  pacificAmmunitionMultiplier: Double,
  olympicSupplyLevelDays: Int
):
  def validated: RedirectResult[SimulationParameters] =
    if etoStrengthVEDay.value <= 0 then
      Left(RedirectViolation(
        RedirectErrorCode.InvalidParameterization, "ETO strength must be positive"))
    else if redeploymentTargetEnd1945.value > etoStrengthVEDay.value then
      Left(RedirectViolation(
        RedirectErrorCode.InvalidParameterization,
        "Redeployment target cannot exceed ETO strength"))
    else if atlanticConvoySpeed.value <= 0.0 || pacificConvoySpeed.value <= 0.0 then
      Left(RedirectViolation(
        RedirectErrorCode.SpeedOutOfRange, "Convoy speeds must be positive"))
    else if (canalDailyTransitCapacity <= 0) ||
            (antwerpDailyDischarge.value <= 0.0) ||
            (forwardAreaDailyDischarge.value <= 0.0) ||
            (divisionSliceTonsPerDay.value <= 0.0) then
      Left(RedirectViolation(
        RedirectErrorCode.InvalidParameterization, "All capacities must be positive"))
    else if pacificAmmunitionMultiplier < 1.0 || pacificAmmunitionMultiplier > 4.0 then
      Left(RedirectViolation(
        RedirectErrorCode.InvalidParameterization,
        "Ammunition multiplier must lie in [1.0, 4.0]"))
    else if olympicSupplyLevelDays < 15 || olympicSupplyLevelDays > 120 then
      Left(RedirectViolation(
        RedirectErrorCode.InvalidParameterization,
        "Supply level must lie in [15, 120] days"))
    else
      Right(this)

object SimulationParameters:

  /** Baseline calibrated to the Section 2 reference table (best estimates). */
  val historicalBaseline: SimulationParameters =
    SimulationParameters(
      etoStrengthVEDay = Troops(3080000),
      pacificStrengthMid1945 = Troops(1400000),
      redeploymentTargetEnd1945 = Troops(1500000),
      vesselsRedirectedEstimate = 300,
      atlanticConvoySpeed = Knots(10.0),
      pacificConvoySpeed = Knots(12.0),
      canalDailyTransitCapacity = 30,
      antwerpDailyDischarge = LongTons(25000.0),
      forwardAreaDailyDischarge = LongTons(5000.0),
      divisionSliceTonsPerDay = LongTons(650.0),
      pacificAmmunitionMultiplier = 2.25,
      olympicSupplyLevelDays = 60
    )

  /** Human-readable diagnostic summarizing the calibrated baseline. */
  def summaryReport(params: SimulationParameters): String =
    val referenceRoutes = RouteDistances(usToEurope = 3500.0, usToPacific = 12500.0)
    val lockageDelay = Days(Constants.PanamaLockageHours / Constants.HoursPerDay)
    val penalty =
      RouteRedirectionModel.extraTransitDays(referenceRoutes, params.atlanticConvoySpeed, lockageDelay)
    val typed = referenceRoutes.typed
    s"""One-Front War baseline:
       |  ETO strength (V-E Day)        : ${params.etoStrengthVEDay.value}
       |  Redeployment target (end-45)  : ${params.redeploymentTargetEnd1945.value}
       |  Vessels redirected (estimate) : ${params.vesselsRedirectedEstimate}
       |  NY-Cherbourg reference leg    : ${typed.usToEuropeNm.value} nm
       |  NY-Manila via Panama          : ${typed.usToPacificNm.value} nm
       |  Redirect transit penalty      : ${penalty.value} days
       |  OLYMPIC supply level          : ${params.olympicSupplyLevelDays} days
       |""".stripMargin
```

**Integration notes.** (1) `historicalBaseline.validated` should be invoked at engine boot; `Left` values map to configuration-load failures. (2) `RouteRedirectionModel.advance` is a pure state-transition kernel — drive it from your tick scheduler; batching 300 diverted hulls through `evaluate` reproduces the May–August 1945 diversion burst. (3) The `Commodity.pacificAlignmentTheta` vector is the simulation encoding of the chapter's central cargo-balance finding and should be recalibrated against any newly digitized WSA manifest samples. (4) All numeric primitives are `opaque`, preventing dimensional errors (e.g., knot-per-day confusion) at compile time.

---

## 6. Graduate-Level Operational Analysis

### 6.1 Why the Redirection of Mid-1945 Proved Among the WSA's Most Complex Scheduling Tasks Ever Attempted

The redirection crisis was not difficult because it was *large*; it was difficult because it coupled three normally separable layers of a logistics system — **physical, informational, and institutional** — into a single tightly bound dynamic problem, under a decision clock compressed by events nobody controlled.

First, consider the **physical layer**. On any given day in mid-1945, roughly forty percent of the U.S.-controlled merchant fleet was underway, loaded, and committed. The Panama Canal offered approximately thirty transits per day against a diversion burst that, spread over ninety days, demanded on the order of three to four slots daily *incrementally* — seemingly trivial, until one models the interaction with existing canal demand, convoy assembly calendars, and berth windows at receiving ports that themselves discharged at one-third to one-tenth of Antwerp's rate. The BPR congestion function of §4.4 explains what the schedulers experienced intuitively: pushing utilization past eighty percent at any red node produced nonlinear delay inflation that cascaded backward through the network as queueing vessels blocked anchorage space, which blocked lighterage cycles, which blocked beach throughput at Okinawa.

Second, the **informational layer**. A vessel's manifest was legally and physically frozen at loading — cargo owned by a dozen agencies, consigned through chains stretching from ASF technical services through port clearing offices to theater depots. An amendment telegraphed from Washington in May arrived, in operational effect, only after the 60–90 day cancellation lag had played out: the system's state included tens of thousands of tons of *irrevocably committed* inventory, exactly the $L = \lambda W$ inertia of §4.4. The WSA was thus running a **manual model-predictive controller** with a two-to-three-month actuation delay and noisy state observation — and the plant it controlled exhibited cargo-mix incompatibility ($\theta \approx 0.4$–$0.6$) that meant even perfectly executed diversions delivered depreciated utility. The redirect-versus-reload breakeven of §4.5 was therefore not an academic refinement but the daily decision: pay the canal's slot-plus-delay price for degraded cargo, or pay the reload cycle's +35–50 days for corrected cargo, knowing that OLYMPIC's 60-day milestone clock did not care which you chose.

Third, the **institutional layer**. Every hull was claimed simultaneously by the JCS MILEPOST milestones, the British import program, UNRRA's relief obligations to liberated Europe, the occupation requirements of a defeated Germany, and the domestic political economy of demobilization. Allocation was lexicographic in principle but contested in practice, with priorities re-litigated weekly as intelligence reassessed Japanese resistance. The combinatorial core — assigning roughly three hundred diverted hulls across candidate Pacific discharge points, berth calendars, and convoy cycles — is an instance of the quadratic assignment problem, attacked in 1945 with punched cards, teletype circuits, and the disciplined judgment of the Office of the Chief of Transportation's routing boards. That the system nonetheless had OLYMPIC's prerequisite tonnage position essentially on schedule by August 1945 is the strongest evidence that the WSA's rolling-horizon amendment process, however primitive by modern OR standards, constituted a genuinely robust — if brittle — control architecture. The war's abrupt end truncated the experiment before the brittleness could be exposed under maximum load.

### 6.2 Psychological and Physical Impacts on ETO Veterans Scheduled for Redeployment

The one-front war was fought in advance upon the minds and bodies of the soldiers who would have waged it, and the documentary record — particularly the Research Branch's *What the Soldier Thinks* surveys and the attitudinal data synthesized in Stouffer et al.'s *The American Soldier* — permits a rigorous reconstruction.

**The expectation-violation shock.** V-E Day produced an intense, army-wide expectation of imminent demobilization, anchored in the publicly announced point system of May 1945. Redeployment orders violated that expectation for precisely the men who had borne the heaviest combat burdens in some cases and, more corrosively, for the *low-point* men who realized they were the designated carriers of the Pacific war. Survey data from mid-1945 show morale indices dipping in formations notified for Pacific movement, with rumor amplification ("the war will be over before we sail") functioning as a collective coping mechanism that command information programs could mitigate but not abolish. The psychological mechanism is textbook relative deprivation: soldiers compared outcomes against reference groups (high-point peers already boarding eastbound transports) rather than against absolute conditions.

**The points paradox and cohesion erosion.** The interaction of individual rotation with unit redeployment was structurally vicious: divisions slated for the Pacific simultaneously lost their highest-score veterans to discharge and received streams of untrained replacements or troops transferred from deactivated units. Unit cohesion — the combat-effective social fabric documented across the Stouffer volumes — was thus degraded *selectively in the formations earmarked for OLYMPIC*. Planners understood the tradeoff explicitly: every acceleration of demobilization purchased domestic political peace at the price of assault-unit readiness, a bargain encoded in the movement tables as competing demands on the same fast hulls (C24-23's 7,000–10,000 troops per day westbound versus the eastbound homeward flow).

**Physical regimens.** Redeployment imposed a measurable physiological program: re-immunization sequences (yellow fever, plague, cholera, typhus), exchange of winter for tropical equipment, jungle-warfare refresher cycles, and acclimatization staging through Hawaii or the Philippines. Troopship transit conditions — berthing densities that modern humanitarian standards would deem unacceptable, with thousands of men aboard converted liners and attack transports for three to five weeks — carried elevated risks of influenza transmission, dermatological disease, and psychological strain, mitigated by shipboard training schedules designed partly as morale therapy. Medical planners additionally anticipated a psychiatric burden: accumulated combat-exhaustion cases from the European campaign, whose symptoms predictably resurfaced under the stress of renewed deployment anxiety, alongside the perennial temptation of the "million-dollar wound."

**The shadow ledger.** The atomic truncation of August 1945 means these impacts were never tested at full amplitude. Counterfactual scholarship — Skates' operational reconstruction, Frank's synthesis of Japanese dispositions, Giangreco's casualty modeling — implies that the veteran force would have confronted Kyushu's defenses at projected cost levels that make the morale question existential rather than managerial. What the record does show, in the occupation-era protests of 1946 among soldiers who *had* been redeployed or retained, is the direction of the gradient: the one-front war's human logistics were the system's least elastic component, and Chapter 24's planners knew it — which is why the movement tables, the point schedules, and the hull allocations of that spring read, in retrospect, like a negotiation with an adversary more unpredictable than the Imperial Navy: the expectations of eight million men.
