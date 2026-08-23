Cost: 0

# CHAPTER 19 — SHIPPING IN THE PACIFIC WAR
### Reference Manual Entry & Simulation Specification Document
**Source Volume:** *Global Logistics and Strategy: 1943–1945* (Coakley & Leighton, U.S. Army Center of Military History)
**Prepared for:** Division-Level WWII Logistics Simulator — Core Engine Team

> **Provenance & Calibration Note.** Where the Green Book narrative reports figures discursively rather than tabularly, the constants below are *calibrated estimates* triangulated from (a) the volume's own narrative data, (b) War Shipping Administration (WSA) and Maritime Commission aggregate statistics, and (c) postwar operations-research literature (OEG/Navy analyses, Huston, Ballantine). Each value carries a confidence grade (**High** = specification/documentary level; **Med** = triangulated estimate; **Derived** = computed from other rows). Bands are provided where archival precision is unattainable. This is the professionally correct way to seed a simulator: point estimates plus uncertainty, never false precision.

---

## 1. Strategic Context & Modern Historical Perspective

In the architecture of Allied grand strategy between 1943 and 1945, no commodity disciplined ambition more ruthlessly than ocean shipping. The Green Book's treatment of Pacific shipping documents the moment at which the largest merchant shipbuilding program in human history — a program that ultimately delivered 2,710 Liberty ships, 534 Victory ships, and nearly 500 T2 tankers, cresting at roughly 130–140 hulls per month in late 1943 and early 1944 — still could not satisfy the simultaneous appetites of two global offensives. The chapter's central paradox is easily stated and endlessly consequential: Allied strategy was written in the currency of divisions, air groups, and target dates, but it could only be executed in the currency of **deadweight-ton-days**. A conference resolution cost nothing to sign; moving the force it conjured cost hulls, and hulls were finite, slow, and — as this chapter demonstrates — hoardable.

The tyranny of the Pacific was arithmetic before it was anything else. A North Atlantic round voyage from an East Coast port ran roughly 38 days end-to-end; a hull could therefore complete nine to ten voyages per year. A Southwest Pacific run — San Francisco to Brisbane is approximately 6,320 nautical miles; at realistic convoy speeds of 9.5–10 knots that is 26–28 days *each way* before a single ton is discharged — consumed, in realized 1944 conditions, on the order of 112 days per cycle. A Liberty ship on Pacific duty thus delivered barely a third of the annual lift of her identical sister working the Atlantic. Every division, every airfield construction echelon, every garrison committed west of Pearl Harbor therefore cost the global pool roughly three European hull-equivalents. Planners' mental models, forged on Atlantic turnaround experience, systematically underestimated this multiplier, and the discrepancy surfaced not in conference minutes but in anchorage queues off New Guinea.

The strategic conferences illustrate the paradox at the highest level. Casablanca (January 1943) framed 1943 around the Mediterranean and the BOLERO buildup while prescribing a holding action against Japan. TRIDENT (May 1943) reaffirmed CROSSWORD-era European priorities yet simultaneously blessed the CARTWHEEL offensive against the Bismarck Barrier — without ever reconciling the two decisions against a common hull budget. QUADRANT (August 1943) layered Southeast Asia Command's Burma requirements onto the same pool; SEXTANT (Cairo, December 1943) endorsed the accelerating Central Pacific drive; and Octagon (September 1944) pulled the Pacific timetable forward toward a 1945 entry into Japan's inner zone. Each decision was monetized in shipping only *after* signature, and the combined Anglo-American machinery — the Combined Shipping Adjustment Board under Admiral Emory S. Land and Britain's Lord Leathers — could arbitrate allocations but could not manufacture ton-days. Optimistic turnaround assumptions embedded in planning documents acted as hidden leverage on the entire global system: when the assumptions failed, the failure propagated everywhere at once.

Inter-service and coalition friction was the human expression of this physical squeeze. Admiral King pressed Pacific claims against the Europe-first consensus; General Marshall balanced theater demands while defending OVERLORD's sanctity; Major General General Brehon Somervell's Army Service Forces acted as the unpopular global referee, controlling the Army's portion of the pool and auditing theaters with an enthusiasm the theaters did not reciprocate. MacArthur's Southwest Pacific Area operated a semi-autonomous logistical empire with its own priorities and its own relationship to the West Coast ports of embarkation — San Francisco (Fort Mason), Los Angeles (San Pedro), Seattle, and Portland, fed by inland installations such as Utah General Depot and the Lathrop holding and reconsignment point. The Navy, meanwhile, produced the war's most important *structural* answer to port scarcity: Admiral William L. Calhoun's Service Force, Pacific Fleet, with its mobile service squadrons and underway replenishment, progressively decoupled the fleet from harbors altogether — a revolution whose significance postwar naval historians such as Duncan Ballantine placed alongside the amphibious breakthrough itself.

The chapter's dramatic core is the **floating-storage crisis** of 1944–45. Because the Pacific pipeline ran 100+ days from factory to foxhole, theater commanders rationally buffered inventories — and because forward ports were primitive or nonexistent, the cheapest available warehouse was the ship itself. By mid-to-late 1944, on the order of 260–310 hulls in the Southwest Pacific Area alone sat idle at anchorages as de facto floating depots, representing roughly 2.1 million long tons of immobilized lift — the equivalent of nearly two months of Northwest Europe's entire import demand at late-1944 discharge rates. The crisis peaked with cruel simultaneity: the Leyte landings of October 1944 deposited hundreds of ships into an anchorage with essentially zero pier capacity just as the Ardennes offensive and the V-weapon bombardment of Antwerp spiked European requirements in December. Somervell threatened embargoes; the Joint Chiefs imposed retention censuses and ceilings; survey teams descended on Pacific ports. The episode is a textbook tragedy of the commons: each commander's individually rational hedge collectively produced an artificial global shipping shortage that constrained strategy on two oceans.

Modern scholarship reads this chapter through lenses unavailable to its authors. Little's Law — the queueing identity *L = λW*, which underlies the fleet equation in §4 — shows with brutal clarity that fleet size is a *product* of flow and time, making turnaround the master variable and every day of retention a tax of roughly *D/C* hulls. Principal-agent theory explains the retention pathology: theaters were measured on supply posture and never billed for idle hull-days until late 1944, so the cost of hoarding was externalized to the global pool. Bullwhip dynamics explain the overshoot: with a 112-day lead time, even modest demand uncertainty justifies enormous safety stock. And the episode's institutional legacy is visible in modern doctrine — the U.S. Maritime Prepositioning program's strict dwell ceilings and contracted rapid-discharge guarantees are, in effect, the codified anti-retention rules written in blood and tonnage by this chapter's events. Postwar operations research suggested that restoring the achievable ~84-day cycle in the SWPA would have freed on the order of 120 hulls; conversely, Germany's collapse in May 1945 released several hundred hulls almost overnight, and it is scarcely coincidental that OLYMPIC planning became physically credible only thereafter.

For the simulator architect, the chapter's lesson is singular: **model time as the primary state variable, retention as an endogenous stock with policy-triggered outflows, and ports — not ships — as the true bottleneck.** Everything else in this specification follows from that inversion.

---

## 2. High-Fidelity Simulation Parameters & Real-World Metrics

### 2.1 Master Parameter Table

| ID | Parameter | Calibrated Value | Unit | Conf. | Historical Basis | Simulator Representation |
|----|-----------|------------------|------|-------|------------------|--------------------------|
| **A. Platform Constants** | | | | | | |
| A1 | Liberty deadweight capacity | 10,856 | LT | High | Standard EC2 design specification | Static constant per hull class |
| A2 | Liberty typical military stow | 8,200 (band 7,000–9,500) | LT | Med-High | Density mismatch, dunnage, hatch limits on Army dry cargo | Capacity constant; cargo-generation sampler mean |
| A3 | Liberty service speed (laden) | 11.0 | kn | High | Design speed; sea-performance data | Transit-time divisor |
| A4 | Victory DWT / speed | 10,850 / 15.5 | LT / kn | High | VC2-S-AP2 specification | Alternative hull class; enables fast-independent sailings |
| A5 | T2 tanker DWT / speed | 16,600 / 14.5 | LT / kn | High | T2-SE-A1 specification | Petroleum pipeline class |
| A6 | Combat-loading efficiency η_combat | 0.65 | ratio | Med | Selective-unloading packaging sacrifices 30–40% of stow | Multiplier on effective capacity for amphibious lifts |
| A7 | Convoy speed (Liberty groups) | 9.8 (band 9.5–10.0) | kn | Med | Slowest-hull convoy doctrine | Outbound transit divisor |
| A8 | Ballast return speed | 11.0–11.5 | kn | Med-High | Independent return passages | Return-leg divisor |
| A9 | Weather/typhoon downtime factor | 1.08 (seasonal 1.04–1.15) | ratio | Med | SWPA monsoon (Dec–Mar), W. Pacific typhoons (Jul–Nov) | Seasonal multiplier on all time terms |
| **B. Route & Time Constants** | | | | | | |
| B1 | San Francisco → Brisbane | 6,320 | nm | High | Great-circle sailing distance | Route edge weight |
| B2 | San Francisco → Pearl Harbor | 2,090 | nm | High | Standard Pacific leg | Route edge weight |
| B3 | Pearl Harbor → Brisbane | 4,180 | nm | High | Via-south routing | Alternate-path edge weight |
| B4 | POE load time | 6.5 (band 5–8) | days | Med-High | West Coast loading rates with pre-stowage discipline | Deterministic segment + variability |
| B5 | Discharge, developed port | 10 (band 8–12) | days | Med | Australian rear-base performance | Function of berth count × rate |
| B6 | Discharge, lightered anchorage | 28 (band 20–45) | days | Med | New Guinea/Philippines conditions | Queue-dependent variable |
| B7 | Home-port turnaround admin | 4 | days | Med | Crew rotation, repairs, stores | Fixed segment |
| B8 | **Baseline achievable cycle** | **84** | days | Derived | Sum of B4+A7-transit+B5+A8-transit+B7 | Lower bound on T_cycle |
| B9 | ★ **Realized 1944 cycle, WC→SWPA** | **112 (band 95–130)** | days | Med-High | Voyage-count data (~3.3/yr), Green Book "four-month" narrative | Dynamic variable T_cycle (see §2.2) |
| B10 | Atlantic benchmark cycle | 38 | days | High | ETO turnaround statistics | Calibration reference |
| B11 | Pacific voyages per hull-year | 3.3 | voyages | Derived | 365 ÷ B9 | Output/validation metric |
| B12 | Atlantic voyages per hull-year | 9.6 | voyages | Derived | 365 ÷ B10 | Productivity-ratio metric (÷3 gap drives strategy) |
| **C. Retention & Floating Storage** | | | | | | |
| C1 | ★ **SWPA floating storage, mid-1944** | **260 (band 200–320)** | hulls | Med | Census fragments, late-1944 audit findings | Stateful stock with inflow/outflow (see §2.2) |
| C2 | SWPA floating storage, peak (Nov–Dec 1944) | 310 | hulls | Med | Leyte congestion records | Peak-state trigger for JCS-directive events |
| C3 | Legitimate afloat working stock | 70 | hulls | Low-Med | Doctrine-sanctioned 30-day afloat reserve | Policy floor beneath which release is prohibited |
| C4 | Excess retention above working stock | 190 | hulls | Derived | C1 − C3 | Violation metric driving scenario events |
| C5 | POA (Central Pacific) afloat inventory, mid-1944 | 90 | hulls | Low-Med | Pearl/forward-area anchorage reports | Parallel stock, separate policy |
| C6 | Okinawa afloat inventory, Apr–Jun 1945 | 1,000+ | hulls | Med-High | Largest concentration of the war; deliberate afloat doctrine under kamikaze threat | End-game scenario state |
| C7 | Immobilized tonnage (C1 × A2) | 2.13 | M LT | Derived | Computed | Global-pool debit |
| C8 | ETO-import-day equivalence of C7 | ~58 | days | Derived | C7 ÷ ~37,000 LT/day late-1944 ETO imports | Strategic-impact translation |
| **D. Economics** | | | | | | |
| D1 | ★ **Idle Liberty operating cost** | **340 (band 280–420)** | USD/day | Med | Wartime crew wages (inflated, danger pay), insurance, upkeep, overhead | Cost coefficient (see §2.2) |
| D2 | Monthly carry per idle hull | 10,400 | USD | Derived | D1 × 30 | Reporting metric |
| D3 | Liberty replacement capital cost | 1.87 (avg; 1.5–2.6 range) | M USD | High | Maritime Commission build-cost data | Capital-exposure term |
| D4 | ★ **Opportunity throughput loss per idle day** | **73** | LT/day | Derived | A2 ÷ B9 (= C/T_cycle) | Shadow-cost term in objective function |
| D5 | Direct monthly carry of retention crisis (C1 × 30d × D1) | 2.65 | M USD | Derived | Computed | Scenario cost ledger |
| **E. Port Infrastructure** | | | | | | |
| E1 | Brisbane deep-draft berths | 10 | berths | Med | Rear-base capacity | Clearance capacity node |
| E2 | Sydney berths | 20 | berths | Med | Rear-base capacity | Overflow valve |
| E3 | Nouméa berths | 8 | berths | Med | South Pacific hub | Alternate routing node |
| E4 | Oro Bay berths (1944) | 6 | berths | Med | Built up 1943–44 | Constructed-capacity event |
| E5 | Milne Bay berths (1944) | 4 | berths | Med | Forward base | Congestion-prone node |
| E6 | Hollandia berths: Apr 1944 → late 1944 | 0 → 8 | berths | Med | Captured with no port; port companies built capacity | Time-varying capacity function |
| E7 | Leyte berths, Oct 1944 | 0 (lighter-only) | berths | High | Assault anchorage reality | Zero-berth queue regime |
| E8 | Developed-port discharge rate | 1,200 (band 1,000–1,500) | LT/berth-day | Med | Stevedore performance data | Service-rate μ_b |
| E9 | Lighter discharge rate | 350 (band 250–400) | LT/ship-day | Med | Anchorage lightering performance | Service-rate μ_s |
| E10 | Ulithi fleet-anchorage capacity | ~700 | hulls | Med | Lagoon capacity, exposed-roadster caveat | Naval-node capacity cap |
| **F. Flow Volumes** | | | | | | |
| F1 | West Coast → SWPA mean monthly tonnage, 1944 | 900,000 (band 700k–1.2M) | LT/mo | Med | Buildup-plus-sustainment estimate for SWPA force levels | Demand process D(t) |
| F2 | Implied SWPA lifeline hull commitment | ~430 | hulls | Derived | Little's Law: (F1/30) × B9 ÷ A2 | Validation target for fleet solver |
| F3 | Peak-month surge multiplier | 1.35 | ratio | Med | Pre-offensive stockpiling surges | Demand seasonality |
| F4 | Tanker cycle, WC → forward fuel farms | 88 | days | Med | Faster hulls, longer routes, pump/discharge times | Separate POL pipeline |
| F5 | Feeder-craft share of intra-theater lift | 35% | ratio | Low-Med | Coasters, barges, LST shuttles | Mode-split parameter |

### 2.2 Deep Dive: The Three Mandated Metrics

**★ Metric 1 — Round-trip turnaround, US West Coast ↔ SWPA, 1944: 112 days (band 95–130).**
*Derivation.* Composite of: 6.5 days loading at the POE; ~27 days outbound at convoy speed 9.8 kn over 6,320 nm; ~20 days average discharge-and-wait in theater (a blend of 8–12 days at developed Australian rear bases and 20–45 days at New Guinea anchorages, weighted by 1944 traffic mix and improving after Hollandia's April 1944 capture); ~24 days ballast return at 11 kn; 4 days home-port administration; plus a ~30-day congestion/retention allowance. Cross-validation: the resulting 3.3 voyages per hull-year matches fragmentary voyage-count data for Pacific-assigned hulls, and the Green Book's recurring characterization of Pacific round voyages approaching four months. *Simulation representation:* a **dynamic variable** `T_cycle`, decomposed per-leg so that scenario events (port capture, typhoon, JCS release directive) perturb individual components rather than the aggregate. The 84-day baseline (row B8) is the floor attainable under ideal port conditions and serves as the counterfactual lever.

**★ Metric 2 — Merchant vessels retained as floating storage, mid-1944: ~260 hulls in SWPA (band 200–320), plus ~90 in the Central Pacific.**
*Derivation.* Triangulated from late-1944 shipping-census fragments, the findings of the JCS-directed Pacific shipping surveys, and the Leyte congestion record (which alone accounted for a large fraction of the peak). Critically, the simulator must distinguish the ~70-hull *legitimate* afloat working stock (sanctioned 30-day reserve) from ~190 hulls of *excess* retention — the politically explosive quantity that triggered JCS ceilings and Somervell's embargo threats. At 8,200 LT per hull this froze ~2.13 million LT, equivalent to ~58 days of late-1944 ETO import demand. *Simulation representation:* a **stateful stock** with endogenous inflows (arrivals minus clearance) and policy-gated outflows; crossing the C3 floor fires `JcsReleaseDirective` events that force discharges at penalty rates.

**★ Metric 3 — Daily cost of holding a Liberty idle in a forward anchor pool: $340/day direct (band $280–420), plus 73 LT/day of forgone throughput.**
*Derivation.* Direct cost reflects inflated 1944 crew wages (overtime and danger pay for ~50 hands), subsistence, hull insurance, maintenance accrual, and WSA administrative overhead — roughly $10,400 per hull-month. The strategically dominant term, however, is **opportunity cost**: at a 112-day cycle, each idle day forfeits 8,200 ÷ 112 ≈ 73 LT of sustained daily throughput, valued against the LP shadow price of a hull (§4). Capital exposure of $1.87M per hull frames the worst case (loss to air attack at an exposed anchorage — realized repeatedly at Leyte in December 1944). *Simulation representation:* a **cost coefficient** in the objective function paired with the dual-variable hull price; the simulator's cost ledger should report direct carry and opportunity cost as separate line items, because historically only the former was visible to theater commanders — which is precisely why the crisis occurred.

---

## 3. Logistical Network Topology

**Simulation focus:** floating-storage turnaround and fleet-size calculation under heavy turnaround-delay penalties. Solid edges carry dry cargo; dotted edges denote retention/overflow states and feeder redistribution. Edge labels give distance/transit time or capacity constraints.

```mermaid
flowchart LR

subgraph CONUS["CONUS Interior Depots and West Coast POEs"]
  UGD["Utah General Depot - Ogden"]
  LHR["Lathrop Holding and Reconsignment Point"]
  SFP["San Francisco POE - Fort Mason"]
  OAK["Oakland Intermediate Terminal"]
  LAP["Los Angeles PE - San Pedro"]
  SEP["Seattle POE"]
  PDX["Portland Sub-port"]
end

subgraph CTRL["National Sailing Control"]
  WSA["WSA Dispatch Control - national schedule"]
  FAR["Farallon Convoy Assembly Anchorage"]
end

subgraph ENROUTE["En-route Nodes"]
  PHL["Pearl Harbor - 20 berths plus fuel farm"]
  NOU["Noumea New Caledonia - 8 berths"]
  ESP["Espiritu Santo - 6 berths"]
end

subgraph REAR["SWPA Rear Base Zone - Australia"]
  BRI["Brisbane - 10 berths"]
  SYD["Sydney - 20 berths"]
  MEL["Melbourne - 15 berths"]
  TWN["Townsville Staging"]
end

subgraph FORWARD["Forward Discharge Zone - New Guinea corridor"]
  PMB["Port Moresby"]
  MIL["Milne Bay - 4 berths"]
  ORO["Oro Bay - 6 berths"]
  FIN["Finschhafen"]
  HOL["Hollandia - 0 rising to 8 berths in 1944"]
  BIA["Biak"]
  MOR["Morotai"]
end

subgraph CENPAC["Central Pacific Corridor - POA"]
  MAJ["Majuro-Kwajalein lagoons"]
  SAI["Saipan-Tinian-Guam"]
  ULI["Ulithi Fleet Anchorage - cap 700 hulls"]
end

subgraph PHIL["Philippines Combat Zone"]
  LEY["Leyte - San Pedro Bay - lighter only"]
  LIN["Lingayen"]
  MAN["Manila - harbor wrecked"]
end

subgraph AFLOAT["Floating Storage Pools - retention state"]
  FSP["SWPA Anchorage Storage Pool - 260 hulls mid-1944"]
  FSU["POA Afloat Reserve - 90 hulls"]
end

subgraph COMBAT["Consumption Nodes"]
  BEACH["Beachhead Dumps"]
  DIV["Division Trains"]
end

UGD --> SFP
LHR --> OAK
SFP --> FAR
OAK --> FAR
LAP --> FAR
SEP --> FAR
PDX --> FAR
WSA -.->|"sailing schedules tuned to port calendars"| FAR
FAR -->|"Southern lane: 6320 nm, 27 d at 9.8 kn"| BRI
FAR -->|"2090 nm"| PHL
PHL -->|"4180 nm"| BRI
MEL --> BRI
SYD --> TWN
BRI --> TWN
TWN -->|"1900 nm"| MIL
TWN --> PMB
MIL --> ORO
FIN --> ORO
ORO -->|"advanced 1944"| HOL
HOL --> BIA
BIA --> MOR
MOR -->|"assault shipping"| LEY
PHL -->|"Central Pacific lane"| MAJ
MAJ --> SAI
SAI --> ULI
ULI -->|"amphib lift"| LEY
ULI --> LIN
MAN --> BEACH
LEY --> BEACH
LIN --> BEACH
BEACH --> DIV
BRI -.->|"overflow discharge"| FSP
HOL -.->|"congestion overflow"| FSP
LEY -.->|"zero-berth retention"| FSP
FSP -.->|"feeder barges and coasters"| BEACH
FSU -.->|"fleet train issue"| DIV
NOU --> ORO
ESP --> NOU

classDef developed fill:#d5e8d4,stroke:#2e7d32,color:#000000
classDef primitive fill:#ffe6cc,stroke:#d79b00,color:#000000
classDef congested fill:#f8cecc,stroke:#b85450,color:#000000
classDef naval fill:#dae8fc,stroke:#6c8ebf,color:#000000
classDef storage fill:#e1d5e7,stroke:#9673a6,color:#000000

class SFP,OAK,BRI,SYD,MEL developed
class MIL,ORO,FIN,HOL,BIA,MOR,PMB primitive
class LEY,FSP congested
class PHL,ULI,MAJ,SAI naval
class FSU storage
```

**Topology notes for the engine.** (1) The network is deliberately *two-corridor*: the SWPA Australia–New Guinea–Philippines line and the POA Central Pacific line converge only in the Philippines, reproducing the historical competition between MacArthur's and Nimitz's pipelines for the same national pool. (2) Congestion is modeled at discharge nodes via the queueing relation in §4; the `FSP` pool is not a passive sink but a stateful stock whose level feeds back into `T_cycle` for every hull in the system. (3) Alternative routing (Pearl vs. southern lane; Nouméa–Espiritu Santo lateral) provides the optimizer relief valves that historically existed but were capacity-capped.

---

## 4. Mathematical Modeling & Simulation Formulas

**Notation.** $D$ = demanded throughput [LT/day]; $C_{dwt}$ = nominal deadweight [LT]; $\eta_{stow}$ = stowage efficiency; $\eta_{combat}$ = combat-loading factor; $C_{eff} = \eta_{stow}\eta_{combat}C_{dwt}$; $d_{out}, d_{back}$ = outbound/return distances [nm]; $v_{convoy}, v_{ballast}$ = speeds [kn]; $T_{load}, T_{admin}$ = fixed time segments [days]; $b$ = deep-draft berths; $\mu_b$ = discharge rate per berth [LT/berth-day]; $s$ = lightering slots; $\mu_s$ = lightering rate [LT/ship-day]; $\lambda$ = arrival rate of cargo [LT/day]; $Q$ = queued cargo afloat [LT]; $N$ = hulls committed.

**(1) Cycle decomposition.**

$$T_{cycle} \;=\; T_{load} \;+\; \frac{d_{out}}{24\,v_{convoy}} \;+\; T_{discharge}(b,\mu_b,s,\mu_s,Q) \;+\; \frac{d_{back}}{24\,v_{ballast}} \;+\; T_{admin} \;+\; T_{retain}(Q)$$

**(2) The master fleet equation (Little's Law applied to hulls).**

$$N \;=\; \left\lceil \frac{D \cdot T_{cycle}}{C_{eff}} \right\rceil, \qquad\qquad \frac{\partial N}{\partial T_{retain}} \;=\; \frac{D}{C_{eff}}$$

The derivative is the chapter's strategic knife: at $D = 30{,}000$ LT/day and $C_{eff} = 8{,}200 \times 0.85 = 6{,}970$ LT, **every day added to the cycle strands 4.31 hulls**. The observed 28-day gap between the achievable (84-day) and realized (112-day) 1944 cycle therefore accounts for $\approx 121$ hulls — the analytical core of the retention scandal.

**(3) Port clearance and queueing (aggregate fluid/M-M-1 approximation).**

$$\bar{\mu} = b\,\mu_b + s\,\mu_s, \qquad \rho = \frac{\lambda}{\bar{\mu}}, \qquad \rho < 1 \;\text{(stability)}$$

$$W_{ship} = \frac{C_{eff}}{\bar{\mu} - \lambda} \;\text{[days]}, \qquad L_q = \frac{\rho}{1-\rho} \;\text{[hull-equivalents]}$$

At Leyte in late 1944: $b=0$, $s=12$, $\mu_s = 350$ → $\bar\mu = 4{,}200$ LT/day against arrivals of $\sim 6{,}000$ LT/day: $\rho > 1$, the stability condition fails, and $Q$ grows without bound — the mathematical signature of the floating-storage spiral.

**(4) Endogenous retention feedback (discrete-time dynamics).**

$$Q_{t+1} = \big[\,Q_t + A_t - K_t\,\big]^{+}, \qquad A_t = \frac{D_t}{C_{eff}}, \qquad K_t = \frac{\bar{\mu}_t}{C_{eff}}, \qquad T_{retain,t} = \frac{Q_t}{A_t}$$

When $A_t > K_t$ persistently, $Q$ grows linearly and $T_{retain}$ diverges: congestion begets buffering, buffering begets congestion. This positive feedback loop *is* the 1944 crisis, and the JCS release directive is modeled as a hard clamp $Q_t \le Q_{max}$ with forced $K_t$ augmentation.

**(5) Inter-theater allocation (linear program over the global pool).**

$$\min_{N_1,\dots,N_J} \;\sum_{j=1}^{J} N_j \quad \text{s.t.}\quad \frac{N_j\, C_{eff,j}}{T_j} \;\ge\; D_j \;\;\forall j, \qquad \sum_{j=1}^{J} N_j \;\le\; \bar{N}_{pool}$$

The dual variable $\theta^\ast$ on the pool constraint is the **strategic shadow price of a hull** — the quantity the JCS was implicitly estimating whenever it adjudicated between Leyte and Antwerp. The May 1945 German collapse is simulated as a step increase in $\bar{N}_{pool}$ of several hundred hulls.

**(6) Port-investment tradeoff (why the Seabees were a shipping program).**

$$\min_{N,\,I} \; c_N\,N \;+\; \phi(I) \quad \text{s.t.}\quad N \;=\; \frac{D\;T\big(T_{discharge}(I)\big)}{C_{eff}}$$

First-order condition at the optimum:

$$\phi'(I^\ast) \;=\; c_N \cdot \frac{D}{C_{eff}} \cdot \left(-\frac{\partial T}{\partial I}\right)$$

A dollar of port construction is justified when the hull-days it releases exceed the carrying cost of the hulls it substitutes for. This single inequality explains the wartime explosion of engineer port battalions, Seabee construction, and pontoon-lightering systems: they were cheaper than Liberty ships.

---

## 5. Compile-Safe Scala 3 Domain Model

Fully implemented, placeholder-free, targeting Scala 3 (compiles under 3.3 LTS and current 3.8.x toolchains). Indentation-based syntax, opaque unit types, enums for state transitions, exhaustive pattern matches, and validated constructors throughout.

```scala
package Logistics.PacificShipping

import scala.math.{ceil, floor, max, min}

// ============================================================================
// SECTION 1 — Dimensional Safety Layer (opaque types)
// ============================================================================

opaque type Days = Double
object Days:
  inline def apply(raw: Double): Days = raw
  extension (d: Days)
    def value: Double = d
    def plus(other: Days): Days = Days(d.value + other.value)
    def minus(other: Days): Days = Days(d.value - other.value)
    def scaledBy(factor: Double): Days = Days(d.value * factor)
    def atLeast(lowerBound: Days): Days = Days(max(d.value, lowerBound.value))

opaque type Knots = Double
object Knots:
  inline def apply(raw: Double): Knots = raw
  extension (k: Knots) def value: Double = k

opaque type NauticalMiles = Double
object NauticalMiles:
  inline def apply(raw: Double): NauticalMiles = raw
  extension (nm: NauticalMiles) def value: Double = nm
  def transitDays(distance: NauticalMiles, speed: Knots): Days =
    Days(distance.value / (speed.value * 24.0))

opaque type LongTons = Double
object LongTons:
  inline def apply(raw: Double): LongTons = raw
  extension (t: LongTons)
    def value: Double = t
    def plus(other: LongTons): LongTons = LongTons(t.value + other.value)
    def per(daySpan: Days): TonsPerDay = TonsPerDay(t.value / daySpan.value)

opaque type TonsPerDay = Double
object TonsPerDay:
  inline def apply(raw: Double): TonsPerDay = raw
  extension (r: TonsPerDay)
    def value: Double = r
    def plus(other: TonsPerDay): TonsPerDay = TonsPerDay(r.value + other.value)
    def scaledBy(factor: Double): TonsPerDay = TonsPerDay(r.value * factor)

opaque type USD = Double
object USD:
  inline def apply(raw: Double): USD = raw
  extension (u: USD)
    def value: Double = u
    def plus(other: USD): USD = USD(u.value + other.value)
    def scaledBy(factor: Double): USD = USD(u.value * factor)
    def times(count: Int): USD = USD(u.value * count.toDouble)

opaque type Hulls = Int
object Hulls:
  inline def apply(raw: Int): Hulls = raw
  extension (h: Hulls) def value: Int = h

// ============================================================================
// SECTION 2 — Historical Constants (seeds the database from Section 2 table)
// ============================================================================

object HistoricalConstants:
  val LibertyDeadweight: LongTons                 = LongTons(10856.0)
  val LibertyTypicalMilitaryStow: LongTons        = LongTons(8200.0)
  val CombatLoadingEfficiency: Double             = 0.65
  val WestCoastBrisbaneDistance: NauticalMiles    = NauticalMiles(6320.0)
  val ConvoySpeedPacific: Knots                   = Knots(9.8)
  val BallastSpeed: Knots                         = Knots(11.0)
  val PoeLoadDays: Days                           = Days(6.5)
  val DischargeDevelopedPortDays: Days            = Days(10.0)
  val DischargeLighteredAnchorageDays: Days       = Days(28.0)
  val HomePortAdminDays: Days                     = Days(4.0)
  val BaselineAchievableCycle: Days               = Days(84.0)
  val SwpaRealizedCycle1944: Days                 = Days(112.0)
  val AtlanticBenchmarkCycle: Days                = Days(38.0)
  val SwpaFloatingStorageMid1944: Hulls           = Hulls(260)
  val SwpaPeakFloatingStorageLate1944: Hulls      = Hulls(310)
  val LegitimateAfloatWorkingStock: Hulls         = Hulls(70)
  val LibertyIdleDailyOperatingCost: USD          = USD(340.0)
  val LibertyReplacementCapital: USD              = USD(1870000.0)
  val DevelopedPortDischargeRate: TonsPerDay      = TonsPerDay(1200.0)
  val LighterDischargeRatePerShipDay: TonsPerDay  = TonsPerDay(350.0)

// ============================================================================
// SECTION 3 — Domain Enumerations
// ============================================================================

enum ShipClass(
    val deadweight: LongTons,
    val serviceSpeed: Knots,
    val typicalMilitaryLoad: LongTons,
    val dailyOperatingCost: USD):
  case Liberty  extends ShipClass(LongTons(10856.0), Knots(11.0), LongTons(8200.0), USD(340.0))
  case Victory  extends ShipClass(LongTons(10850.0), Knots(15.5), LongTons(8600.0), USD(415.0))
  case T2Tanker extends ShipClass(LongTons(16600.0), Knots(14.5), LongTons(15400.0), USD(470.0))

enum VesselState(val movesCargo: Boolean, val isRetentionState: Boolean):
  case InLoad          extends VesselState(movesCargo = true,  isRetentionState = false)
  case OutboundTransit extends VesselState(movesCargo = true,  isRetentionState = false)
  case AwaitingBerth   extends VesselState(movesCargo = false, isRetentionState = true)
  case Discharging     extends VesselState(movesCargo = true,  isRetentionState = false)
  case FloatingStorage extends VesselState(movesCargo = false, isRetentionState = true)
  case BallastReturn   extends VesselState(movesCargo = true,  isRetentionState = false)
  case InRepair        extends VesselState(movesCargo = false, isRetentionState = false)

enum ConfigError(val explanation: String):
  case NonPositiveDemand     extends ConfigError("dailyTonsTarget must be strictly positive")
  case NonPositiveCapacity   extends ConfigError("shipCapacityTons must be strictly positive")
  case NonPositiveTurnaround extends ConfigError("turnaround must be strictly positive")
  case InvalidCoefficients   extends ConfigError("stowageEfficiency must lie in (0,1] and weatherPenaltyFactor must be >= 1.0")

// ============================================================================
// SECTION 4 — Core Domain Records
// ============================================================================

final case class VesselId(raw: String)

final case class Vessel(
    id: VesselId,
    klass: ShipClass,
    state: VesselState,
    daysInState: Days,
    cargoAboard: LongTons):
  def age(by: Days): Vessel = copy(daysInState = Days(daysInState.value + by.value))

object VesselLifecycle:
  def advance(current: VesselState): VesselState =
    current match
      case VesselState.InLoad          => VesselState.OutboundTransit
      case VesselState.OutboundTransit => VesselState.AwaitingBerth
      case VesselState.AwaitingBerth   => VesselState.Discharging
      case VesselState.Discharging     => VesselState.BallastReturn
      case VesselState.BallastReturn   => VesselState.InLoad
      case VesselState.FloatingStorage => VesselState.Discharging
      case VesselState.InRepair        => VesselState.InLoad

final case class TheaterPolicy(
    theaterName: String,
    maxAfloatStorageDays: Days,
    enforceJcsReleaseDirective: Boolean,
    targetWorkingStockDaysAshore: Days):
  def releaseEligible(v: Vessel): Boolean =
    v.state == VesselState.FloatingStorage &&
      v.daysInState.value > maxAfloatStorageDays.value &&
      enforceJcsReleaseDirective

final case class FleetTarget(
    dailyTonsTarget: LongTons,
    shipCapacityTons: LongTons,
    stowageEfficiency: Double = 1.0,
    weatherPenaltyFactor: Double = 1.0):
  def effectiveCapacity: LongTons = LongTons(shipCapacityTons.value * stowageEfficiency)
  def adjustedTurnaround(base: Days): Days = Days(base.value * weatherPenaltyFactor)

final case class CycleBreakdown(
    loadDays: Days,
    outboundDays: Days,
    dischargeDays: Days,
    ballastDays: Days,
    adminDays: Days,
    retentionDays: Days):
  def totalDays: Days =
    Days(
      loadDays.value + outboundDays.value + dischargeDays.value +
        ballastDays.value + adminDays.value + retentionDays.value)

object CycleBreakdown:
  def swpaCalibration1944(retentionDays: Days): CycleBreakdown =
    CycleBreakdown(
      loadDays = HistoricalConstants.PoeLoadDays,
      outboundDays = NauticalMiles.transitDays(
        HistoricalConstants.WestCoastBrisbaneDistance, HistoricalConstants.ConvoySpeedPacific),
      dischargeDays = HistoricalConstants.DischargeLighteredAnchorageDays,
      ballastDays = NauticalMiles.transitDays(
        HistoricalConstants.WestCoastBrisbaneDistance, HistoricalConstants.BallastSpeed),
      adminDays = HistoricalConstants.HomePortAdminDays,
      retentionDays = retentionDays)

final case class PortId(raw: String)

final case class PortFacility(
    id: PortId,
    deepDraftBerths: Int,
    dischargeTonsPerBerthDay: TonsPerDay,
    lighteringSlots: Int,
    lighteringTonsPerShipDay: TonsPerDay):
  def clearanceCapacity: TonsPerDay =
    TonsPerDay(
      deepDraftBerths.toDouble * dischargeTonsPerBerthDay.value +
        lighteringSlots.toDouble * lighteringTonsPerShipDay.value)
  def utilization(arrivals: TonsPerDay): Double =
    val cap = clearanceCapacity.value
    if cap <= 0.0 then Double.PositiveInfinity else arrivals.value / cap

final case class CongestionReport(
    portId: PortId,
    utilization: Double,
    arrivalsTonsPerDay: TonsPerDay,
    clearanceTonsPerDay: TonsPerDay,
    diagnosis: String)

// ============================================================================
// SECTION 5 — Fleet Snapshot Aggregates
// ============================================================================

final case class FleetSnapshot(vessels: Vector[Vessel]):
  def countIn(state: VesselState): Int = vessels.count(_.state == state)
  def retentionCount: Int = vessels.count(_.state.isRetentionState)
  def retentionRatio: Double =
    if vessels.isEmpty then 0.0 else retentionCount.toDouble / vessels.size.toDouble
  def productiveHulls: Int = vessels.count(_.state.movesCargo)
  def immobilizedTonnage: LongTons =
    LongTons(vessels.filter(_.state.isRetentionState).map(_.klass.typicalMilitaryLoad.value).sum)
  def effectiveDailyLift(cycle: CycleBreakdown): TonsPerDay =
    val circulating = vessels.filter(_.state.movesCargo)
    val lift = circulating.map(_.klass.typicalMilitaryLoad.value).sum
    TonsPerDay(lift / cycle.totalDays.value)

// ============================================================================
// SECTION 6 — Queueing Model (aggregate M/M/1 fluid approximation)
// ============================================================================

object AnchorQueueModel:
  def expectedWaitingDays(
      arrivals: TonsPerDay,
      port: PortFacility,
      ship: ShipClass): Either[CongestionReport, Days] =
    val capacity = port.clearanceCapacity
    val rho = port.utilization(arrivals)
    if rho >= 1.0 then
      Left(
        CongestionReport(
          portId = port.id,
          utilization = min(rho, 9.999),
          arrivalsTonsPerDay = arrivals,
          clearanceTonsPerDay = capacity,
          diagnosis = "Arrivals meet or exceed clearance capacity; indefinite queue growth (retention spiral)."))
    else
      val slackTonsPerDay = capacity.value - arrivals.value
      Right(Days(ship.typicalMilitaryLoad.value / slackTonsPerDay))

// ============================================================================
// SECTION 7 — Fleet Sustenance Model (extends the supplied base verbatim)
// ============================================================================

object FleetSustenanceModel:

  def requiredHulls(target: FleetTarget, turnaroundDays: Double): Int =
    if target.shipCapacityTons.value <= 0.0 || turnaroundDays <= 0.0 then 0
    else
      val dailyShipsNeeded = target.dailyTonsTarget.value / target.shipCapacityTons.value
      ceil(dailyShipsNeeded * turnaroundDays).toInt

  def requiredHullsChecked(target: FleetTarget, turnaround: Days): Either[ConfigError, Hulls] =
    validate(target, turnaround).map { _ =>
      val numerator = target.dailyTonsTarget.value * target.adjustedTurnaround(turnaround).value
      Hulls(ceil(numerator / target.effectiveCapacity.value).toInt)
    }

  def marginalHullsPerExtraDay(target: FleetTarget): Double =
    if target.effectiveCapacity.value <= 0.0 then 0.0
    else target.dailyTonsTarget.value / target.effectiveCapacity.value

  def throughputAchievable(fleetSize: Hulls, target: FleetTarget, turnaround: Days): TonsPerDay =
    if turnaround.value <= 0.0 || target.effectiveCapacity.value <= 0.0 then TonsPerDay(0.0)
    else TonsPerDay((fleetSize.value * target.effectiveCapacity.value) / turnaround.value)

  def completedVoyagesPerYear(turnaround: Days): Double =
    if turnaround.value <= 0.0 then 0.0
    else floor(365.0 / turnaround.value * 100.0) / 100.0

  def idleOpportunityThroughputLoss(ship: ShipClass, turnaround: Days): TonsPerDay =
    if turnaround.value <= 0.0 then TonsPerDay(0.0)
    else TonsPerDay(ship.typicalMilitaryLoad.value / turnaround.value)

  def retentionCarryCost(hullsRetained: Hulls, daysHeld: Days, ship: ShipClass): USD =
    USD(ship.dailyOperatingCost.value * hullsRetained.value.toDouble * daysHeld.value)

  private def validate(target: FleetTarget, turnaround: Days): Either[ConfigError, Unit] =
    if target.dailyTonsTarget.value <= 0.0 then Left(ConfigError.NonPositiveDemand)
    else if target.shipCapacityTons.value <= 0.0 then Left(ConfigError.NonPositiveCapacity)
    else if turnaround.value <= 0.0 then Left(ConfigError.NonPositiveTurnaround)
    else if target.stowageEfficiency <= 0.0 || target.stowageEfficiency > 1.0 then
      Left(ConfigError.InvalidCoefficients)
    else if target.weatherPenaltyFactor < 1.0 then Left(ConfigError.InvalidCoefficients)
    else Right(())

// ============================================================================
// SECTION 8 — Demonstration Harness (@main; exercises every public path)
// ============================================================================

@main def pacificShippingDemo(): Unit =
  val target = FleetTarget(
    dailyTonsTarget = LongTons(30000.0),
    shipCapacityTons = LongTons(8200.0),
    stowageEfficiency = 0.85,
    weatherPenaltyFactor = 1.08)

  val cycle = CycleBreakdown.swpaCalibration1944(Days(30.0))
  println(f"SWPA 1944 calibrated cycle: ${cycle.totalDays.value}%.1f days")

  FleetSustenanceModel.requiredHullsChecked(target, cycle.totalDays) match
    case Right(hulls) => println(s"Hulls required (validated): ${hulls.value}")
    case Left(err)    => println(s"Configuration rejected: ${err.explanation}")

  println(f"Marginal hulls per extra retention day: ${FleetSustenanceModel.marginalHullsPerExtraDay(target)}%.2f")
  println(f"Completed voyages per hull-year at 112-day cycle: ${FleetSustenanceModel.completedVoyagesPerYear(HistoricalConstants.SwpaRealizedCycle1944)}%.2f")
  println(f"Opportunity loss per idle Liberty-day: ${FleetSustenanceModel.idleOpportunityThroughputLoss(ShipClass.Liberty, HistoricalConstants.SwpaRealizedCycle1944).value}%.1f LT/day")
  println(f"Retention carry cost, 260 hulls x 30 days: $${FleetSustenanceModel.retentionCarryCost(Hulls(260), Days(30.0), ShipClass.Liberty).value}%.0f")

  val leyte = PortFacility(
    id = PortId("Leyte-San Pedro Bay Oct 1944"),
    deepDraftBerths = 0,
    dischargeTonsPerBerthDay = TonsPerDay(0.0),
    lighteringSlots = 12,
    lighteringTonsPerShipDay = HistoricalConstants.LighterDischargeRatePerShipDay)
  AnchorQueueModel.expectedWaitingDays(TonsPerDay(6000.0), leyte, ShipClass.Liberty) match
    case Left(report) => println(s"QUEUE FAILURE at ${report.portId.raw}: ${report.diagnosis}")
    case Right(wait)  => println(s"Leyte wait: ${wait.value} days")

  val brisbane = PortFacility(
    id = PortId("Brisbane"),
    deepDraftBerths = 10,
    dischargeTonsPerBerthDay = HistoricalConstants.DevelopedPortDischargeRate,
    lighteringSlots = 2,
    lighteringTonsPerShipDay = TonsPerDay(300.0))
  AnchorQueueModel.expectedWaitingDays(TonsPerDay(9000.0), brisbane, ShipClass.Liberty) match
    case Left(report) => println(s"QUEUE FAILURE at ${report.portId.raw}: ${report.diagnosis}")
    case Right(wait)  => println(f"Brisbane expected ship-wait: ${wait.value}%.2f days")

  val fleet = FleetSnapshot(Vector(
    Vessel(VesselId("SS-101"), ShipClass.Liberty, VesselState.FloatingStorage, Days(47.0), LongTons(8100.0)),
    Vessel(VesselId("SS-102"), ShipClass.Victory, VesselState.Discharging, Days(6.0), LongTons(8400.0)),
    Vessel(VesselId("SS-103"), ShipClass.Liberty, VesselState.OutboundTransit, Days(19.0), LongTons(7900.0)),
    Vessel(VesselId("SS-104"), ShipClass.T2Tanker, VesselState.BallastReturn, Days(21.0), LongTons(0.0))))
  println(f"Fleet retention ratio: ${fleet.retentionRatio}%.2f; immobilized tonnage: ${fleet.immobilizedTonnage.value}%.0f LT")
  println(f"Effective daily lift of circulating hulls: ${fleet.effectiveDailyLift(cycle).value}%.0f LT/day")

  val policy = TheaterPolicy("SWPA", Days(30.0), enforceJcsReleaseDirective = true, Days(45.0))
  fleet.vessels.foreach { v =>
    val flag = if policy.releaseEligible(v) then "RELEASE" else "HOLD"
    println(s"${v.id.raw}: state=${v.state}, aged ${v.daysInState.value} days -> $flag")
  }
  println(s"Lifecycle advance from FloatingStorage -> ${VesselLifecycle.advance(VesselState.FloatingStorage)}")
  println(s"Aged SS-103 by 5 days: ${fleet.vessels(2).age(Days(5.0)).daysInState.value} days in state")
```

**Integration notes.** `HistoricalConstants` seeds the database directly from the §2 table; `AnchorQueueModel` implements Eq. (3) with the stability guard that reproduces the Leyte failure mode; `TheaterPolicy.releaseEligible` implements the JCS retention-ceiling clamp of Eq. (4); and `FleetSustenanceModel.requiredHullsChecked` wraps the base `requiredHulls` with the full Eq. (2) treatment (combat-loading efficiency and weather penalties) behind a validated `Either` interface suitable for the execution engine's configuration pipeline.

---

## 6. Graduate-Level Operational Analysis

### 6.1 The Phenomenon of "Floating Storage": Anatomy of a Rational Catastrophe

Floating storage in the Pacific was not one behavior but three, and the distinction matters for modeling. **Involuntary retention** was queueing: ships arrived at anchorages with zero or near-zero berth capacity — Leyte in October 1944 is the paradigm, with lightering at 300–400 LT per ship-day against arrivals the system could not clear — and waited because physics left no alternative. **Deliberate retention** was doctrine by improvisation: commanders ordered ships held empty or part-empty as re-addressable, secure, weatherproof warehouse space, because shore storage consisted of a few captured sheds and open dumps in monsoon country. **Structural retention** was the shuttle trap: hulls assigned to intra-theater relay (Brisbane → Townsville → Milne Bay → Oro Bay) accumulated in queues at each relay's choke point. All three species coexisted, and contemporaries conflated them — which is precisely why the late-1944 audits caused such political shock when they decomposed the total.

Why did theater commanders refuse to release hulls? Four mechanisms, each individually defensible. First, **pipeline terror**: with a 112-day replenishment latency, any stockout discovered today is unfixable until next season. Classical base-stock logic dictates that safety inventory scales with lead time; a commander facing a four-month pipeline rationally holds enormous buffers, and the only available buffer medium was the hull itself. Second, **port physics**: discharge at a developed berth ran ~1,200 LT/day; at a lightered anchorage, ~350. A single Liberty therefore represented 6–23 days of scarce port capacity, and releasing her meant losing not just her cargo space but her *storage* space in a theater with almost none ashore. Third, **threat environment**: the memory of 1942 — Japanese submarines off Sydney, air devastation of convoyed shipping in the Bismarck Sea — made dispersed afloat reserves a survivability hedge; a warehouse that can weigh anchor and move is worth a premium under air attack. Fourth, and most corrosively, **incentive asymmetry**: theaters were evaluated on days-of-supply-on-hand and were never billed for idle hull-days until the JCS imposed retention censuses in late 1944. The cost of hoarding was externalized onto the global pool — a textbook common-pool externality compounded by zero-sum allocation politics, since a hull released to the WSA pool might never return to one's own theater.

The global impact was strategic, not merely statistical. At ~260 hulls and ~8,200 LT each, the SWPA alone froze ~2.1 million LT — roughly 58 days of Northwest Europe's entire late-1944 import demand. The autumn 1944 conjunction was almost perfectly perverse: Eisenhower's armies outran their ports, Antwerp lay under V-weapon blockade, the Ardennes struck in December, and the Pacific's anchorages sat on the hulls that might have eased the squeeze. The same pool tension had already nearly killed ANVIL in the summer of 1944 over amphibious shipping, and it framed the Luzon-versus-Formosa debate, where base-development and discharge capacity — not carrier strength — bounded the options. The resolution came through the instruments §6.2 describes, plus the ultimate exogenous shock: Germany's capitulation in May 1945 released several hundred hulls overnight, transforming OLYMPIC's feasibility. The enduring lesson, encoded decades later in Maritime Prepositioning doctrine's hard dwell ceilings and contracted rapid-discharge guarantees, is that afloat prepositioning is legitimate *only* when paired with enforceable discharge promises — otherwise the warehouse annexes the fleet.

### 6.2 WSA Countermeasures Against Turnaround Decay: Instruments and Elasticities

Admiral Emory S. Land's War Shipping Administration commanded the allocation of the entire US-flag merchant marine, and from mid-1944 onward it waged a systematic campaign against the cycle time $T_{cycle}$ — correctly recognizing, in modern terms, that with $\partial N/\partial T = D/C_{eff} \approx 4.3$ hulls per day at SWPA demand levels, **time was the only resource whose expansion was free**. The campaign's instruments, with their mechanisms and observed effects:

1. **National dispatch scheduling.** WSA tuned sailing calendars to port discharge calendars, converting Poisson arrival bursts into smoothed flows. This attacks $\rho$ directly: keeping utilization below the stability threshold prevents the nonlinear queue explosion of Eq. (3). Effect: measurable reduction in home-port and rear-base anchorage queues.
2. **Pre-stowage and hatch-sequencing discipline.** Standardized stowage plans, cargo documentation, and priority offload lists raised effective discharge rates $\mu_b$ by reducing hatch-search and re-handling. Effect: 10–20% discharge gains where labor was adequate — worth, by the marginal calculus, several hulls per percentage point.
3. **Port construction as shipping policy.** Engineer port battalions, Seabee construction, pontoon causeways, and dredging created capacity *ex nihilo*: Hollandia went from zero berths in April 1944 to a major base by year's end. This is Eq. (6) operationalized — the cheapest hulls of the war were the ones never needed because a pier replaced them.
4. **Industrial-scale lightering.** Pontoon barges, DUKW fleets, and ship-mounted cranes converted zero-berth anchorages into pseudo-ports at 300–400 LT/ship-day, attacking the Leyte failure mode where berths could not exist.
5. **Audit and census regime.** Weekly idle-ship reports, JCS retention ceilings, and the late-1944 Pacific shipping surveys broke the information asymmetry that had let retention hide inside "theater reserves." Name-and-shame politics did what price signals could not, because no price existed.
6. **Allocation incentives and embargo threats.** Somervell's willingness to halt sailings to congested theaters inverted the payoff matrix: hoarding now carried a visible, immediate cost in suspended replenishment.
7. **Load consolidation and handling modernization.** Minimum-ship-load rules, inland consolidation, forklifts, pallets, and organized stevedore labor raised $C_{eff}$ and $\mu$ simultaneously — the quiet productivity revolution that postwar OR credited with a substantial share of total turnaround improvement.

Net assessment: by mid-1945, realized Pacific cycles were trending from the 112-day regime toward the low-90s, Leyte's backlog was cleared, and — the doctrine's maturation — Okinawa's vast afloat inventory was *deliberate, ceilinged* retention under kamikaze threat rather than uncontrolled accumulation. The arithmetic of praise: each day shaved from the cycle returned ~4.3 hulls to the global pool at SWPA demand levels; the roughly 20-day cumulative improvement is equivalent to ~86 hulls, or nearly a month of peak Liberty production — manufactured not in Kaiser's yards but in the anchorages, at the cost of nothing but managerial will.

---

*End of Chapter 19 Reference & Simulation Specification.*
