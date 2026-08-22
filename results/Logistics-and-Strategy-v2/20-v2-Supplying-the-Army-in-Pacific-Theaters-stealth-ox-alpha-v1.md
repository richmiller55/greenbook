Cost: 0

# Chapter 20 — *Supplying the Army in Pacific Theaters*
## Principal Reference Manual & Simulation Specification Document
**Source Text:** Coakley & Leighton, *Global Logistics and Strategy: 1943–1945*, United States Army in World War II (the "Green Book"), Vol. II
**Prepared for:** Division-level WWII logistics simulator — database schema, network topology, and state-transition engine
**Code Target:** Scala 3 (written for 3.8.3; compiles on any Scala 3.3+ toolchain)

---

### 1. Strategic Context & Modern Historical Perspective

#### 1.1 The Strategic Paradox: Conference Rooms versus Hull Arithmetic

On paper, Allied grand strategy was settled at Casablanca (January 1943): defeat Germany first, contain Japan, reinforce the Pacific only to the extent of a "limited offensive." But grand strategy is executed in deadweight tons, crane-hours, and calendar days, and the physical instrument of coalition warfare — the combined shipping pool — obeyed an arithmetic that no communiqué could suspend. Every infantry division dispatched to Australia or New Guinea consumed on the order of thirty to forty laden sailings; every round trip on the ~6,300-nautical-mile San Francisco–Brisbane corridor locked a hull out of productive use for roughly ninety days (load 5–9 days, steam ~25, discharge 10–20, return ~25, voyage repairs and ballasting the remainder). The pipeline, not the battlefront, was the binding constraint, and the great conferences of 1943–1944 — TRIDENT (Washington, May 1943), QUADRANT (Quebec, August 1943), SEXTANT–EUREKA (Cairo–Tehran, November–December 1943), and OCTAGON (Quebec, September 1944) — were, beneath their strategic language, negotiations over the margin between the BOLERO buildup for OVERLORD and the Pacific's expanding appetite.

The paradox sharpened with time. The "secondary" theater absorbed a steadily rising share of American dry-cargo sailings and westbound troop movements; by 1944 the Pacific accounted for something on the order of half of U.S. oceangoing employment. General Brehon Somervell's Army Service Forces (ASF) repeatedly warned that unbounded Pacific commitments threatened to become a sinkhole draining the European buildup — the logistical mirror image of the "Germany first" political formula. Meanwhile the operational tempo outran the allocations: the CARTWHEEL directive of mid-1943 set the dual-axis advance against Rabaul; SEXTANT ratified the twin drives (MacArthur along the New Guinea coast, Nimitz through the Central Pacific); and the OCTAGON cycle then accelerated the Leyte invasion from December 1944 to October 1944, amputating two months from a timetable already stretched across inadequate forward anchorages. Hollandia — seized in April 1944 largely *because* its terrain permitted depot construction — became the improvised hinge of the entire Philippines operation, its swamp-edge stockpiles carrying a burden no planner had assigned it eighteen months earlier.

Combat loading dramatized the collision between tactics and tonnage. A vessel stowed for amphibious sequence — what the shore party needs first stacked highest and nearest the hatch — surrendered roughly 30–40 percent of usable cubic capacity relative to commercial maximum stowage. An amphibious operation therefore cost a third more hull-days than the manifest suggested: an invisible tax levied by tactical method upon strategic resource, and one reason theater commanders fought Washington over every combat-loaded sailing.

#### 1.2 Inter-Service and Coalition Friction

Three fault lines structured Pacific logistics politics:

1. **ASF versus Theater Services of Supply.** Somervell's zone-of-interior machine measured success in tons loaded at the port of embarkation; the theater's USASOS (United States Army Services of Supply, Southwest Pacific Area — commanded by Brig. Gen. James L. Frink from 1943, then Lt. Gen. Wilhelm D. Styer, whose command was redesignated AFWESPAC in 1945) measured success in tons *cleared* through ports that the monsoon, the enemy, and broken stowage jointly contested. Forward combat headquarters — Krueger's Sixth Army, and Alamo Force — clashed persistently with base-section officers over beach-clearance priority, stock control authority, and the diversion of infantry into emergency stevedore battalions, as at Hollandia where combat troops labored as dockhands for weeks.

2. **Army versus Navy.** In the Pacific Ocean Areas (POA), Vice Adm. William L. Calhoun's Service Force, Pacific Fleet, controlled the preponderance of logistics, while the Army's SOSPOA duplicated warehousing, port, and distribution functions in the same anchorages — two parallel systems sharing one lagoon. In SWPA, MacArthur's GHQ (with Chief of Staff Lt. Gen. Richard Sutherland exercising tight personal control over supply channels) ran a third system, jealously guarded from Washington interference. Admiral King pressed Central Pacific priorities; General Marshall defended BOLERO; MacArthur cultivated press and political leverage to pry loose allocations. Coordination was personal, episodic, and opaque.

3. **Coalition pooling.** Unlike the European theater's comparatively integrated arrangements, the Pacific operated on the looser ANZAC Combined Board (established early 1942) reconciling American, Australian, and New Zealand shipping. Britain, fighting its own tonnage war against the U-boat, had little capacity to pool east of India. Allocation consequently proceeded by negotiation and personality rather than by transparent price mechanism — precisely the environment in which the dual variables of a transportation linear program (the "shadow prices" of §4) would have exposed the true strategic cost of each conference promise.

#### 1.3 Historical Era Context: Climate as the Third Enemy

Chapter 20's distinctive contribution is its granular treatment of tropical climate as an adversary co-equal with the Japanese army. New Guinea coastal depots operated at mean relative humidities of 80–92 percent, mean temperatures near 86 °F, and rainfalls approaching 200 inches per year at Milne Bay. Above 70 percent sustained relative humidity, mold sporulates on organic packaging; above roughly 75 percent, atmospheric corrosion of ferrous metals accelerates sharply. Paperboard equilibrated sopping wet; canvas rotted, webbing mildewed, boot leather "jungled," optical instruments fungused, and smokeless propellant absorbed moisture until misfires multiplied. Quartermaster storage surveys catalogued losses that read like sabotage: paper-packed subsistence lots deteriorating 30–60 percent within ninety equatorial days; textile stocks recoverable at barely 40 percent through salvage; wooden ammunition boxes delaminating until their contents were compromised.

The institutional response evolved from improvisation (grease, tarpaulins, sun-drying details) to industrial materials science: Cu-8 (copper-8-quinolinolate) fungicidal impregnation of textiles; vaporproof ("V") packing specifications; asphalt-laminated kraft barrier board; paraffin–microcrystalline wax dips; Pliofilm (rubber hydrochloride) and Saran (PVDC) films; silica-gel desiccants paired with cobalt-chloride humidity-indicator cards; sealed metal ammunition containers of the M19-series; and lyophilized (dried) plasma, stable at tropical ambient temperatures — arguably the single highest-value packaging achievement of the war, measured in lives per cubic foot. In parallel, the ration system was redesigned for the tropics: the C ration (~6 lb, ~3,300 kcal/man-day), the K ration (2.75 lb, 2,830 kcal, devised under Ancel Keys in 1941), the dehydrated Jungle ration (Type J, ~4 lb, 3,430 kcal, adopted 1943 and phased out amid acceptability failures), and the group-fed 10-in-1 that became the 1944 workhorse.

#### 1.4 Modern Analytical Insights

Postwar scholarship reframes the chapter decisively. Phillips Payson O'Brien (*How the War Was Won*, 2015) locates the decisive struggle precisely in these tonnage streams — the war as a contest of shipping, airpower, and distribution rather than of battlefield genius. Economic historians (Harrison et al.) quantify the American merchant-marine expansion — a fleet that roughly tripled, exceeding 30 million deadweight tons by 1945, with 2,710 Liberty ships alone — that made Pacific audacity affordable at all. The founding generation of operations research traces its lineage directly to these allocation crises: Tjalling Koopmans' tanker-routing analyses for the Combined Shipping Adjustment Board (later Nobel-cited) and Blackett's methods matured against exactly the bottleneck mathematics formalized in §4.

Material-science hindsight vindicates the packaging program as foundational: the modern MIL-SPEC packaging apparatus and ASTM distribution-cycling protocols descend in a direct line from SWPA failure reports. One popular claim — that "over half of all ammunition and rations shipped to the South Pacific arrived unusable" — deserves modern precision: aggregate theater-wide losses were grave but uneven, with the catastrophic figures attaching to *specific* paperboard-packaged subsistence, signal, and medical lots in equatorial storage. This is exactly why the simulator below carries decay coefficients indexed by commodity × packaging × climate cell rather than a single theater constant. Finally, the chapter anticipates contemporary "distribution-based logistics" doctrine: ports, not divisions, were the operative constraint — a lesson relearned in every expeditionary war since.

---

### 2. High-Fidelity Simulation Parameters & Real-World Metrics

**Epistemic note:** Primary-source archives report *ranges*; the point estimates below are calibrated representatives suitable as database constants, each tagged with provenance and its correct simulation-theoretic role (static constant, dynamic capacity cap, efficiency coefficient, or state variable).

| ID | Parameter | Point Value | Documented Range | Unit | Provenance / Basis | Simulation Representation |
|----|-----------|------------|------------------|------|--------------------|---------------------------|
| P-01 | Mean RH, New Guinea jungle depots | **85** | 80–92 | % | Depot-site meteorological records, 1943–44 | Static climate constant (drives decay coupling) |
| P-02 | Mean ambient temp., lowland NG depots | 86 | 82–90 | °F | Same | Static climate constant |
| P-03 | Mean monthly rainfall, Milne Bay | 16.5 | 12–20 | in/month | Station records (~200 in/yr) | Static climate constant |
| P-04 | Mold-initiation humidity threshold | 70 | 68–72 | % sustained | QM mycology studies | Model switching threshold |
| P-05 | Accelerated-corrosion humidity threshold | 75 | 73–80 | % | Atmospheric-corrosion literature | Model switching threshold |
| P-06 | **Dry-ration rot loss ≤ 90 days, bare paperboard, equatorial storage** | **45** | 30–60 | % | QMC storage-inspection surveys 1942–43 | Derived decay coefficient α ≈ 0.28/month |
| P-07 | Same, vaporproof barrier packing | 8 | 5–12 | % | QM "V-packing" acceptance trials | α ≈ 0.062/month |
| P-08 | Same, sealed metal container | 8 | 5–10 | % | Ordnance container trials | α ≈ 0.028/month |
| P-09 | K ration gross weight | 2.75 | 2.6–2.9 | lb/man-day | QM Subsistence Research Lab specs | Demand coefficient |
| P-10 | K ration energy content | 2,830 | 2,700–2,900 | kcal/man-day | Same | Diet-model input |
| P-11 | C ration gross weight / energy | 6.0 / 3,300 | 5.5–6.2 / 3,300–3,700 | lb; kcal | QM specs (late-war improvement) | Demand coefficient |
| P-12 | Jungle ration (Type J) weight / energy | 4.0 / 3,430 | — | lb; kcal | 1943 adoption data | Demand coefficient |
| P-13 | 10-in-1 ration (per-man equivalent) | 5.5 / 3,760 | — | lb; kcal | 1944 issue data | Demand coefficient |
| P-14 | Heavy tropical labor energy requirement | 4,400 | 4,000–4,800 | kcal/man-day | Military nutrition physiology | Diet-model input |
| P-15 | **Mean soldier weight loss, exclusive K-ration diet, 40 days heavy labor** | **18** | 15–22 | lb/man | SWPA/SOPAC medical board surveys | Dynamic state variable (ODE, §4 M6) |
| P-16 | Adipose energy density | 3,500 | — | kcal/lb | Physiology constant | Conversion constant |
| P-17 | Drinking-water requirement, tropics | 4–10 | — | qt/man-day | Theater medical doctrine | Demand floor (non-shippable locally) |
| P-18 | Liberty ship: DWT / practical lift | 10,800 / 9,000 | — | short tons | Maritime Commission | Vessel capacity constant |
| P-19 | Victory ship practical lift | 10,500 | — | short tons | Maritime Commission | Vessel capacity constant |
| P-20 | West Coast→Australia: steam / full cycle | 25 / 90 | 23–28 / 85–100 | days | Convoy schedules, WSA | Pipeline lag; fleet factor Φ ≈ 3.0–3.6 |
| P-21 | Major base-port discharge rate | 2,000–3,200 | — | tons/day | Base-section reports (Brisbane ≈ 3,200) | Capacity cap μₚ |
| P-22 | Forward-beach discharge rate | 500–1,500 | — | tons/day | Amphibious after-action reports | Capacity cap μₚ |
| P-23 | Monsoon anchorage queue delay | 20–45 | — | days | Nov–Mar, forward anchorages | Congestion delay (queue state) |
| P-24 | Fresh-ration demand unmet by reefer lift, 1943 | >60 | 55–75 | % | Reefer-pool analyses | Capacity gap (structural deficit) |
| P-25 | Malaria:battle-casualty admission ratio, 1943 | ~5:1 theater; up to 20:1 command peaks | — | ratio | Preventive-medicine reports | Manpower attrition coefficient |
| P-26 | Atabrine-discipline effect, 1944 | ≈ −90 | 80–93 | % rate reduction | Same | Policy lever |
| P-27 | Vaporproof packaging weight penalty | 21 | 8–30 | % of net weight | Packaging specifications | Payload efficiency coefficient |
| P-28 | Combat-load cube utilization | 60–70 | — | % | Amphibious stowage studies | Stowage efficiency coefficient |
| P-29 | Air-freight cost premium vs. surface | 6–10 | — | × | ATC cost analyses | Alternative-route premium |
| P-30 | Textile salvage recovery rate | ~40 | 30–50 | % | Salvage-depot reports | Recycling coefficient |

#### 2.1 Deep Dive — P-06: Ninety-Day Rot Loss of Dry Rations (45%, range 30–60%)

This is the chapter's headline material constant. QMC inspection teams walking equatorial dumps in 1942–43 recorded paperboard-packaged biscuits, flour mixes, powdered eggs, and dehydrated vegetables losing between a third and three-fifths of gross weight to mold, insect infestation following moisture breach, and rust-through of cans stored against wet earth. The mechanism is sorption physics: hygroscopic paperboard equilibrates with ambient humidity, transmitting moisture inward; fungal germination initiates above the ~70% threshold (P-04) and proceeds exponentially, not linearly — hence the exponential decay formulation of §4. Strategically, this constant converted directly into shipping demand: every ton lost forward had to be shipped twice. **Simulation encoding:** not a static loss percentage but a *first-order decay coefficient* α (month⁻¹) conditioned on packaging class and climate cell, integrated continuously over dwell time. The 45% point corresponds to α ≈ 0.28/month under bare paperboard at 85% RH / 86 °F (worked example in §4).

#### 2.2 Deep Dive — P-15: Weight Loss on Prolonged K-Ration Diet (18 lb/man over 40 days; 15–22 lb documented band)

Medical boards surveying Bougainville, Saidor, and Aitape troops documented average body-weight losses of 15–22 pounds among men subsisting exclusively on K rations for four to six weeks under heavy labor. The arithmetic is unforgiving: 2,830 kcal supplied against ~4,400 kcal expended (P-14) yields a 1,570 kcal/day deficit; at 3,500 kcal per pound of adipose tissue (P-16), the energy-balance prediction is ≈ 0.45 lb/day, or ≈ 18 lb over 40 days — squarely inside the clinical band. **Simulation encoding:** a *dynamic state variable* governed by the ODE of §4 M6, coupled to a combat-effectiveness index; it must interact with ration-issue policy, workload regime, and (via fresh-ration availability) an acceptability coefficient that captures "food fatigue" under-consumption.

#### 2.3 Deep Dive — P-01: New Guinea Depot Relative Humidity (85% mean; 80–92% range)

Annual means at forward depot complexes (Milne Bay, Lae–Finschhafen, Hollandia) clustered near 85 percent, with limited diurnal relief and wet-season excursions toward 92 percent. This single number is the master driver of the decay model: it sits fifteen points above the mold threshold and ten above the corrosion threshold, placing every stored commodity permanently inside the deterioration regime. **Simulation encoding:** a *static climate constant* attached to each depot node, consumed by the humidity-acceleration function g(H) of §4 M2; sensitivity runs should sweep 80–92% to bound wet-season risk.

---

### 3. Logistical Network Topology (Detailed Mermaid.js Flowchart)

**Simulation focus:** tropical material spoilage and stock decay over time; congestion at anchorages; alternative routing via air and cross-theater transfers. Edge labels encode lift (tons/month), transit days, and relative decay-hazard multipliers.

```mermaid
flowchart LR

subgraph ZI["ZONE OF INTERIOR — PORTS OF EMBARKATION"]
  SF["San Francisco POE<br/>outload 4,800 t/day"]
  LA["Los Angeles POE<br/>outload 3,200 t/day"]
  SEA["Seattle POE<br/>outload 2,400 t/day"]
end

subgraph LANES["TRANS-PACIFIC SHIPPING PIPELINE"]
  SP([\"Southern Route — SF to Brisbane<br/>6,300 nm · steam 25 d · cycle 90 d<br/>decay hazard x1.0\"])
  CP([\"Central Route — WC to Pearl to Majuro<br/>4,900 nm · steam 19 d\"])
  REEFER[[\"Reefer Pool<br/>under 6 pct of lift<br/>fresh-ration priority\"]]
end

subgraph TB["THEATER BASE SECTIONS — SWPA AND POA"]
  BRIS["Base B — Brisbane<br/>discharge 3,200 t/day<br/>covered storage 180,000 t"]
  SYD["Base A — Sydney and Melbourne<br/>discharge 2,800 t/day"]
  NOUM["Nouméa — SOPAC<br/>discharge 2,000 t/day"]
  PEARL["Pearl Harbor — POA hub<br/>discharge 4,000 t/day"]
end

subgraph FW["ADVANCED BASES — NEW GUINEA AXIS"]
  MILNE["Milne Bay Advanced Base<br/>discharge 1,400 t/day<br/>RH 87 pct · 84 degF"]
  LAEFIN["Lae–Finschhafen<br/>discharge 1,100 t/day<br/>RH 86 pct"]
  HOLLA["Hollandia Depot Complex<br/>discharge 1,800 t/day<br/>RH 85 pct · 86 degF"]
  BIAK["Biak<br/>discharge 900 t/day"]
end

subgraph CZ["COMBAT-ZONE DEPOTS"]
  LEYTE["Leyte Beachhead Dumps<br/>discharge 2,200 t/day<br/>RH 88 pct"]
  MANILA["Luzon — Manila Bay<br/>discharge 2,600 t/day"]
end

AIR["ATC AIR-FREIGHT LANE<br/>C-46 and C-47 · 10–14 t per sortie<br/>reserved for criticals, blood, parts"]
PETRO[[\"Bulk Petroleum Network<br/>pipelines and 55-gal drum pool<br/>drum tare approx one-eighth gross\"]]
QMON[\"⚠ Monsoon congestion Nov–Mar<br/>anchorage queue 20–45 days\"]
LEGEND["EDGE KEY<br/>lift t per month · transit days<br/>· decay-hazard multiplier"]

SF -->|\"Liberty convoys<br/>8 sailings per mo · 72,000 t per mo\"| SP
LA -->|\"mixed sailings\"| SP
SEA -->|\"north-Pacific sailings\"| CP
SP -->|\"26–31 d transit<br/>hazard x1.0\"| BRIS
CP -->|\"19–24 d transit\"| PEARL
PEARL -->|\"forward dispatch\"| NOUM
SYD -->|\"coastal feeders\"| BRIS
BRIS -->|\"coastal 1,700 nm · 7–9 d<br/>hazard x1.4\"| MILNE
NOUM -.->|\"cross-theater transfer\"| MILNE
MILNE -->|\"barge and lighter · 300 nm<br/>hazard x1.6\"| LAEFIN
LAEFIN -->|\"coastal 600 nm<br/>hazard x1.6\"| HOLLA
BRIS -.->|\"direct fast convoys<br/>when port pressure allows\"| HOLLA
HOLLA -->|\"amphib task-force lifts<br/>combat-loaded · cube 60–70 pct\"| LEYTE
BIAK -->|\"Palau-axis feeder\"| LEYTE
LEYTE -->|\"interisland feeds\"| MANILA
AIR -.->|\"priority bypass<br/>cost premium 6–10x\"| HOLLA
AIR -.->|\"priority bypass\"| LEYTE
REEFER -.->|\"fresh rations<br/>shore cold-store scarce\"| MILNE
PETRO --- MILNE
PETRO --- HOLLA
QMON -.-> MILNE
QMON -.-> LAEFIN
QMON -.-> HOLLA

classDef poe fill:#dbe9ff,stroke:#1f4e79,color:#000
classDef lane fill:#fff2cc,stroke:#7f6000
classDef base fill:#e2efda,stroke:#375623
classDef fwd fill:#fce4d6,stroke:#833c00
classDef cbt fill:#ffd9d9,stroke:#9c0006
classDef air fill:#deebf7,stroke:#2e74b5,stroke-dasharray: 4 3
classDef warn fill:#ffffff,stroke:#c00000,stroke-width:2px
classDef key fill:#f2f2f2,stroke:#666666

class SF,LA,SEA poe
class SP,CP,REEFER lane
class BRIS,SYD,NOUM,PEARL base
class MILNE,LAEFIN,HOLLA,BIAK,PETRO fwd
class LEYTE,MANILA cbt
class AIR air
class QMON warn
class LEGEND key
```

**Reading guide.**
- **Capacity limits** appear as discharge/outload figures on every port and depot node; these are the hard caps μₚ of §4 M3.
- **Congestion delays** are represented by the monsoon-warning node and by queue-wait states at each anchorage (Little's-law linkage in §4 M3).
- **Alternative routing** is shown as dashed edges: direct Brisbane→Hollandula fast convoys relieving the Milne Bay corridor, cross-theater SOPAC transfers, and the ATC air bypass carrying high-value, low-weight criticals at a 6–10× cost premium.

---

### 4. Mathematical Modeling & Simulation Formulas

#### M1 — First-Order Stock Decay (Core State Equation)

$$
\frac{dS_i}{dt} \;=\; -\,\alpha_i\, S_i \;+\; a_i(t) \;-\; u_i(t),
\qquad S_i(0) = S_{i,0}
$$

Between receipt events ($a_i = u_i = 0$), the analytic solution is the exponential law:

$$
S_i(t) = S_{i,0}\, e^{-\alpha_i t}
$$

**Explanation.** $S_i(t)$ is the serviceable tonnage of commodity class $i$; $\alpha_i$ is the monthly decay coefficient; $a_i(t)$ arrivals; $u_i(t)$ issues. Decay is *proportional to standing stock* — mold consumes what is present — which is why the exponential form, not linear attrition, matches QM survey curves. The legacy base model `SpoilageDepreciationModel.remainingStock` implements exactly this kernel; the production model below replaces the scalar `decayRate` with the environment-coupled coefficient of M2.

#### M2 — Environment-Coupled Decay Coefficient

$$
\alpha_i \;=\; \alpha_i^{(0)} \cdot g(H)\cdot \theta(T)\cdot p_i,
\qquad
g(H) = 1 + \kappa\left[\frac{(H - H_c)^+}{100 - H_c}\right]^{\gamma},
\qquad
\theta(T) = e^{\beta\,(T - T_0)}
$$

**Definitions.** $\alpha_i^{(0)}$: base laboratory decay rate for commodity $i$; $H$: relative humidity (%); $H_c = 70$: mold-initiation threshold (P-04); $\kappa = 8$, $\gamma = 1.6$: fitted humidity gain and curvature; $T$: mean temperature (°F); $T_0 = 59$: reference temperature; $\beta = 0.020\ ^\circ\text{F}^{-1}$: Arrhenius-style thermal sensitivity; $p_i$: packaging protection factor (bare paperboard 1.00 → sealed metal 0.10).

**Worked calibration (ties §2 to §5).** At a New Guinea depot, $H = 85$, $T = 86$: $g = 1 + 8(15/30)^{1.6} = 3.64$; $\theta = e^{0.02 \times 27} = 1.72$; environment multiplier $= 6.25$. For dry rations in bare paperboard, $\alpha = 0.045 \times 6.25 = 0.281\ \text{month}^{-1}$, giving 90-day survival $e^{-0.281 \times 2.96} = 0.43$ — a **57% loss**, reproducing the documented 30–60% band (P-06) and the "over half unusable" regime for vulnerable lots. Under sealed metal ($p = 0.10$), $\alpha = 0.028$, survival 92% — matching P-08.

#### M3 — Port Clearance and Congestion Dynamics

$$
B_p(t+\Delta) = \max\!\big(0,\; B_p(t) + \Lambda_p(t) - \mu_p \Delta\big),
\qquad
W_p = \frac{B_p}{\mu_p}
$$

**Explanation.** $B_p$: backlog at port $p$; $\Lambda_p$: arrival intensity; $\mu_p$: discharge capacity (P-21/P-22 caps); $W_p$: expected anchorage waiting time, the queueing-theoretic quantity that ballooned to 20–45 days (P-23) in monsoon seasons. Little's law ($L = \lambda W$) connects backlog to hull-time destroyed: every waiting day at Hollandia is a Liberty-day denied to some other theater — the physical substrate of the §1 strategic paradox.

#### M4 — Pipeline Arithmetic and the Fleet Factor

$$
\Phi_r = \frac{T_{\text{load}} + T_{\text{steam}} + T_{\text{disch}} + T_{\text{return}}}{T_{\text{steam}}},
\qquad
K_{\text{pinned}}(t) = \sum_r \lambda_r(t)\,\tau_r
$$

**Explanation.** $\Phi_r$ is the round-trip inflation factor (≈ 3.0–3.6 on the Australia run, P-20): sustaining a delivery rate $\lambda_r$ pins $\lambda_r \tau_r$ tons of shipping permanently in the pipeline. This is why conference promises were simultaneously fleet commitments, and why combat-loading's 30–40% cube penalty (P-28) propagated directly into national hull requirements.

#### M5 — Period Allocation Linear Program

$$
\max_{\{x_{iu} \ge 0\}} \;\sum_{u} w_u\, z_u
$$

subject to

$$
z_u \;\le\; \sum_i \epsilon_i\, x_{iu}
\quad \forall u;
\qquad
\sum_{u} x_{iu} \;\le\; S_i^{\text{avail}};
\qquad
\sum_{i,u} \frac{x_{iu}}{e_i} \;\le\; K_{\text{lift}};
\qquad
\sum_{i} x_{ip}^{\text{in}} \;\le\; \mu_p \Delta + B_p^{\text{carry}}
$$

**Definitions.** $x_{iu}$: tons of commodity $i$ allocated to consumer $u$; $w_u$: G-3 operational priority weight; $\epsilon_i = e^{-\alpha_i \tau_i}$: survival-to-delivery fraction (couples M2 into allocation); $e_i$: stowage efficiency (tons carried per capacity-ton, P-28); $K_{\text{lift}}$: period lift capacity; the final constraint enforces port clearance (M3). **Interpretation.** The dual variable on the lift constraint, $\lambda_{\text{lift}}$, is the *shadow price of shipping* — the marginal combat power of one capacity-ton. The conferences of §1 were, in effect, bargaining over $\lambda_{\text{lift}}$ without ever computing it; Koopmans' tanker work was the first serious attempt to do so.

#### M6 — Diet, Body Mass, and Combat Effectiveness

$$
\dot{w} = -\,\frac{R_{\text{act}} - c}{3500},
\qquad
R_{\text{act}} = 3600 + \eta\,\ell,
\qquad
\Psi(w) = \operatorname{clip}\!\left(2.2\,\frac{w}{w_0} - 1.2,\; 0,\; 1\right)
$$

**Explanation.** $w$: mean body weight (lb); $c$: ration energy intake (kcal/day); $R_{\text{act}}$: workload-adjusted requirement ($\eta = 800$ for heavy tropical labor, $\ell \in \{0,1\}$); 3,500 kcal/lb (P-16); $\Psi$: effectiveness index mapping weight retention to combat capability. Calibration: K ration ($c = 2830$) under heavy labor yields $\dot w = -0.449$ lb/day → **18 lb over 40 days** (P-15), and $\Psi \approx 0.75$ — a quarter of effective strength forfeited by the ration system before any shot is fired.

---

### 5. Compile-Safe Scala 3 Domain Model

```scala
package Logistics.SupplyingPacific

import scala.math.exp
import scala.math.max
import scala.math.min
import scala.math.pow
import scala.util.Try

// ===========================================================================
// Section A — Physical Units (opaque types for dimensional safety)
// ===========================================================================

/** Short tons (2,000 lb), the Army's standard cargo accounting unit. */
opaque type ShortTons = Double

object ShortTons:
  def apply(raw: Double): ShortTons =
    require(raw >= 0.0 && raw.isFinite, s"ShortTons must be finite and >= 0, got $raw")
    raw

  val Zero: ShortTons = apply(0.0)

  extension (lhs: ShortTons)
    def raw: Double = lhs
    def +(rhs: ShortTons): ShortTons = lhs + rhs
    def -(rhs: ShortTons): ShortTons =
      val difference = lhs - rhs
      require(difference >= -1e-6, s"ShortTons subtraction underflow: $lhs - $rhs")
      max(difference, 0.0)
    def scaledBy(factor: Double): ShortTons =
      require(factor >= 0.0, "scale factor must be non-negative")
      lhs * factor

/** Elapsed time in days. */
opaque type Days = Double

object Days:
  def apply(raw: Double): Days =
    require(raw >= 0.0 && raw.isFinite, s"Days must be finite and >= 0, got $raw")
    raw

  val Zero: Days = apply(0.0)
  val Month: Days = apply(30.44)

  def fromMonths(months: Double): Days =
    require(months >= 0.0, "months must be non-negative")
    apply(months * 30.44)

  extension (lhs: Days)
    def raw: Double = lhs
    def +(rhs: Days): Days = lhs + rhs
    def -(rhs: Days): Days =
      val difference = lhs - rhs
      require(difference >= -1e-6, s"Days subtraction underflow: $lhs - $rhs")
      max(difference, 0.0)
    def toMonths: Double = lhs / 30.44
    def scaledBy(factor: Double): Days =
      require(factor >= 0.0, "scale factor must be non-negative")
      lhs * factor

/** Relative humidity expressed in percent, bounded to [0, 100]. */
opaque type RelativeHumidity = Double

object RelativeHumidity:
  def percent(pct: Double): RelativeHumidity =
    require(pct >= 0.0 && pct <= 100.0, s"RH percent must lie in [0,100], got $pct")
    pct

  extension (h: RelativeHumidity)
    def percentValue: Double = h
    def isAbove(thresholdPct: Double): Boolean = h > thresholdPct

/** Ambient temperature in degrees Fahrenheit. */
opaque type Fahrenheit = Double

object Fahrenheit:
  def apply(degF: Double): Fahrenheit =
    require(degF >= -100.0 && degF <= 160.0, s"Fahrenheit out of physical range: $degF")
    degF

  extension (t: Fahrenheit)
    def degF: Double = t
    def toCelsius: Double = (t - 32.0) * 5.0 / 9.0

/** First-order exponential decay coefficient, per 30.44-day month. */
opaque type MonthlyDecayRate = Double

object MonthlyDecayRate:
  def apply(raw: Double): MonthlyDecayRate =
    require(raw >= 0.0 && raw.isFinite, s"MonthlyDecayRate must be finite and >= 0, got $raw")
    raw

  val Zero: MonthlyDecayRate = apply(0.0)

  extension (r: MonthlyDecayRate)
    def raw: Double = r

// ===========================================================================
// Section B — Domain Enumerations
// ===========================================================================

/** Broad cargo families tracked by theater stock control, with base decay. */
enum CommodityClass(val baseMonthlyDecayRate: MonthlyDecayRate, val unloadingPriority: Int):
  case DrySubsistence    extends CommodityClass(MonthlyDecayRate(0.045), 2)
  case PerishableFood    extends CommodityClass(MonthlyDecayRate(0.115), 1)
  case SmallArmsAmmo     extends CommodityClass(MonthlyDecayRate(0.020), 3)
  case ArtilleryAmmo     extends CommodityClass(MonthlyDecayRate(0.018), 3)
  case BulkPetroleum     extends CommodityClass(MonthlyDecayRate(0.004), 4)
  case MedicalSupplies   extends CommodityClass(MonthlyDecayRate(0.080), 1)
  case SignalEquipment   extends CommodityClass(MonthlyDecayRate(0.065), 2)
  case EngineerMaterials extends CommodityClass(MonthlyDecayRate(0.008), 5)
  case ClothingTextiles  extends CommodityClass(MonthlyDecayRate(0.055), 4)

/** Inspection classification of stored materiel, per QMC survey practice. */
enum StorageCondition(val label: String):
  case Serviceable    extends StorageCondition("Serviceable")
  case Degraded       extends StorageCondition("Degraded")
  case Unserviceable  extends StorageCondition("Unserviceable")

object StorageCondition:
  /** Thresholds: >= 0.85 serviceable; 0.50–0.85 degraded; below 0.50 unserviceable. */
  def classify(serviceableFraction: Double): StorageCondition =
    require(
      serviceableFraction >= 0.0 && serviceableFraction <= 1.0,
      s"serviceableFraction must lie in [0,1], got $serviceableFraction"
    )
    if serviceableFraction >= 0.85 then StorageCondition.Serviceable
    else if serviceableFraction >= 0.50 then StorageCondition.Degraded
    else StorageCondition.Unserviceable

/** Packaging technology ladder, 1942–1945, with moisture-protection factors. */
enum PackagingStandard(val moisturePenaltyFactor: Double, val addedWeightFraction: Double):
  case BarePaperboard        extends PackagingStandard(1.00, 0.00)
  case WaxedCarton           extends PackagingStandard(0.62, 0.08)
  case AsphaltLaminatedKraft extends PackagingStandard(0.41, 0.14)
  case VaporproofBarrier     extends PackagingStandard(0.22, 0.21)
  case SealedMetalContainer  extends PackagingStandard(0.10, 0.30)

/** Transport modes available to the theater distribution system. */
enum TransportMode(val knots: Double, val tonsPerSailing: ShortTons):
  case LibertyConvoy    extends TransportMode(10.5, ShortTons(9000))
  case VictoryBreakbulk extends TransportMode(15.0, ShortTons(10500))
  case CoastalLighter   extends TransportMode(7.0, ShortTons(350))
  case AirTransportCmd  extends TransportMode(160.0, ShortTons(12))

/** Field ration types with gross logistics weight and energy content. */
enum RationType(val grossPoundsPerManDay: Double, val kilocaloriesPerManDay: Int):
  case CRation       extends RationType(6.00, 3300)
  case KRation       extends RationType(2.75, 2830)
  case JungleRation  extends RationType(4.00, 3430)
  case TenInOne      extends RationType(5.50, 3760)
  case DEmergencyBar extends RationType(0.75, 600)

/** Validation-check outcome states. */
enum CheckStatus:
  case Pass
  case Fail

// ===========================================================================
// Section C — Environmental Profiles and the Decay Engine
// ===========================================================================

/** Aggregated climate record attached to each network node. */
final case class ClimateProfile(
  meanRelativeHumidity: RelativeHumidity,
  meanTemperature: Fahrenheit,
  meanMonthlyRainfallInches: Double
)

object ClimateProfile:
  /** Annual means recorded at forward SWPA depot sites, 1943–1944. */
  val NewGuineaJungleDepot: ClimateProfile =
    ClimateProfile(RelativeHumidity.percent(85.0), Fahrenheit(86.0), 14.2)

  val MilneBay: ClimateProfile =
    ClimateProfile(RelativeHumidity.percent(87.0), Fahrenheit(84.0), 16.5)

  val BrisbaneStaging: ClimateProfile =
    ClimateProfile(RelativeHumidity.percent(68.0), Fahrenheit(70.0), 3.1)

  val SanFranciscoPoe: ClimateProfile =
    ClimateProfile(RelativeHumidity.percent(72.0), Fahrenheit(57.0), 2.4)

  val LeyteBeachhead: ClimateProfile =
    ClimateProfile(RelativeHumidity.percent(88.0), Fahrenheit(85.0), 11.8)

/**
 * Environment-coupled tropical decay engine implementing Model M2.
 *
 * alpha = alphaBase * g(H) * theta(T) * packagingFactor, where
 * g(H) = 1 + kappa * ((H - Hc)+ / (100 - Hc))^gamma and
 * theta(T) = exp(beta * (T - T0)).
 *
 * Default calibration reproduces QMC damp-heat chamber results and
 * Southwest Pacific field survey loss bands (see specification Section 2).
 */
final class TropicalDecayModel(
  val criticalHumidityPct: Double,
  val humidityGain: Double,
  val humidityExponent: Double,
  val thermalBetaPerDegF: Double,
  val referenceTempF: Double
):

  def humidityMultiplier(climate: ClimateProfile): Double =
    val h = climate.meanRelativeHumidity.percentValue
    if h <= criticalHumidityPct then 1.0
    else
      val excess = (h - criticalHumidityPct) / (100.0 - criticalHumidityPct)
      1.0 + humidityGain * pow(excess, humidityExponent)

  def thermalMultiplier(climate: ClimateProfile): Double =
    exp(thermalBetaPerDegF * (climate.meanTemperature.degF - referenceTempF))

  def effectiveDecayRate(
    commodity: CommodityClass,
    packaging: PackagingStandard,
    climate: ClimateProfile
  ): MonthlyDecayRate =
    val alphaBase = commodity.baseMonthlyDecayRate.raw
    val environment = humidityMultiplier(climate) * thermalMultiplier(climate)
    MonthlyDecayRate(alphaBase * environment * packaging.moisturePenaltyFactor)

  def remainingTons(stored: StoredLot, depot: DepotNode, additionalDays: Days): ShortTons =
    val alpha = effectiveDecayRate(stored.lot.commodity, stored.lot.packaging, depot.climate)
    val survived = stored.currentShortTons.raw * exp(-alpha.raw * additionalDays.toMonths)
    ShortTons(survived)

object TropicalDecayModel:
  /** Standard calibrated instance used throughout the simulator. */
  val Standard: TropicalDecayModel = TropicalDecayModel(
    criticalHumidityPct = 70.0,
    humidityGain = 8.0,
    humidityExponent = 1.6,
    thermalBetaPerDegF = 0.020,
    referenceTempF = 59.0
  )

// ===========================================================================
// Section D — Network Entities
// ===========================================================================

/** An identifiable quantity of cargo in a single packaging standard. */
final case class StockLot(
  lotId: String,
  commodity: CommodityClass,
  packaging: PackagingStandard,
  grossShortTons: ShortTons
)

/** A stock lot resident in a depot, with accumulated dwell time. */
final case class StoredLot(
  lot: StockLot,
  daysInStorage: Days,
  currentShortTons: ShortTons
)

/** A physical depot node with climate, storage, and outload capacities. */
final case class DepotNode(
  nodeId: String,
  designation: String,
  climate: ClimateProfile,
  coveredStorageCapacity: ShortTons,
  openStorageCapacity: ShortTons,
  monthlyOutloadCapacity: ShortTons
)

/** A port terminal modeled as a deterministic clearing queue (Model M3). */
final case class PortTerminal(
  portId: String,
  designation: String,
  dailyDischargeCapacity: ShortTons,
  backlogShortTons: ShortTons
):

  def admit(arrival: ShortTons): PortTerminal =
    copy(backlogShortTons = backlogShortTons + arrival)

  def clear(days: Days): (PortTerminal, ShortTons) =
    val worked = min(backlogShortTons.raw, dailyDischargeCapacity.raw * days.raw)
    (copy(backlogShortTons = backlogShortTons - ShortTons(worked)), ShortTons(worked))

  def waitingTimeDays: Days =
    Days(backlogShortTons.raw / dailyDischargeCapacity.raw)

/** Cargo awaiting discharge at a port, bound for a destination depot. */
final case class PendingLot(
  destinationDepotId: String,
  lot: StockLot,
  waitingDays: Days
)

/** A scheduled convoy or flight arrival at a port. */
final case class ScheduledArrival(
  portId: String,
  destinationDepotId: String,
  lot: StockLot
)

/** A recurring shipping connection between two network nodes. */
final case class ShippingLane(
  laneId: String,
  originNodeId: String,
  destinationNodeId: String,
  mode: TransportMode,
  distanceNauticalMiles: Int,
  sailingFrequencyPerMonth: Double
):

  def transitDays: Days = Days(distanceNauticalMiles.toDouble / mode.knots)

  def monthlyLiftCapacity: ShortTons =
    mode.tonsPerSailing.scaledBy(sailingFrequencyPerMonth)

/** Aggregate inspection readout for one depot at one instant. */
final case class DepotReadout(
  depotId: String,
  designation: String,
  totalTons: ShortTons,
  serviceableTons: ShortTons,
  degradedTons: ShortTons,
  unserviceableTons: ShortTons
)

/** Immutable snapshot of the whole network at a day index. */
final case class NetworkState(
  dayIndex: Int,
  depotInventories: Map[String, Vector[StoredLot]],
  portQueues: Map[String, Vector[PendingLot]]
)

// ===========================================================================
// Section E — Field Diet and Effectiveness Model (Model M6)
// ===========================================================================

/** A commanded troop population for diet-effectiveness studies. */
final case class TroopPopulation(
  designation: String,
  strength: Int,
  meanBodyWeightLbs: Double
)

object FieldDietModel:
  val BaselineMetabolicKcal: Int = 3600
  val HeavyTropicalLaborSurchargeKcal: Int = 800
  val KilocaloriesPerPoundAdipose: Double = 3500.0

  def requiredIntakeKcal(heavyLabor: Boolean): Int =
    if heavyLabor then BaselineMetabolicKcal + HeavyTropicalLaborSurchargeKcal
    else BaselineMetabolicKcal

  def dailyDeficitKcal(ration: RationType, heavyLabor: Boolean): Int =
    max(requiredIntakeKcal(heavyLabor) - ration.kilocaloriesPerManDay, 0)

  def projectedWeightLossLbs(ration: RationType, heavyLabor: Boolean, duration: Days): Double =
    val deficit = dailyDeficitKcal(ration, heavyLabor).toDouble
    deficit * duration.raw / KilocaloriesPerPoundAdipose

  /** Transport burden of a ration policy, in short tons per month. */
  def transportTonsPerManMonth(ration: RationType, men: Int): Double =
    ration.grossPoundsPerManDay * men.toDouble * 30.44 / 2000.0

  /** Effectiveness index Psi(w): 1.0 at baseline weight, 0.0 at 54.5 pct retention. */
  def combatEffectivenessIndex(meanWeightLbs: Double, baselineWeightLbs: Double): Double =
    require(baselineWeightLbs > 0.0, "baseline weight must be positive")
    val retention = meanWeightLbs / baselineWeightLbs
    min(1.0, max(0.0, 2.2 * retention - 1.2))

// ===========================================================================
// Section F — The Network Simulator
// ===========================================================================

/**
 * Daily-step simulator of the Pacific distribution network.
 *
 * Each advance performs four phases, in order:
 *   1. scheduled arrivals join their port queues;
 *   2. ports discharge whole lots FIFO up to daily capacity;
 *   3. depot demand draws down stock FIFO by commodity;
 *   4. all stored lots age under the environment-coupled decay model.
 *
 * Unfilled demand is silently reflected as zero delivery for that day;
 * extend the readout layer to surface shortfalls if required.
 */
final class PacificTheaterLogisticsSimulator(
  val decayModel: TropicalDecayModel,
  val depots: Map[String, DepotNode],
  val ports: Map[String, PortTerminal],
  val lanes: Vector[ShippingLane],
  val scheduledArrivals: Map[Int, Vector[ScheduledArrival]],
  val dailyDemandTons: Map[String, Map[CommodityClass, ShortTons]],
  val initialInventories: Map[String, Vector[StoredLot]]
):

  def initialState(): NetworkState =
    NetworkState(
      dayIndex = 0,
      depotInventories = depots.map: (depotId, _) =>
        depotId -> initialInventories.getOrElse(depotId, Vector.empty[StoredLot]),
      portQueues = ports.map: (portId, _) =>
        portId -> Vector.empty[PendingLot]
    )

  def advance(state: NetworkState, days: Int): NetworkState =
    require(days >= 1, s"advance requires days >= 1, got $days")
    val elapsed = Days(days.toDouble)

    // Phase 1 — inbound arrivals join their port queues.
    val todaysArrivals: Vector[ScheduledArrival] =
      scheduledArrivals.getOrElse(state.dayIndex, Vector.empty[ScheduledArrival])

    val queuesAfterArrivals: Map[String, Vector[PendingLot]] =
      todaysArrivals.foldLeft(state.portQueues): (queues, arrival) =>
        val pending = PendingLot(arrival.destinationDepotId, arrival.lot, Days.Zero)
        val existing = queues.getOrElse(arrival.portId, Vector.empty[PendingLot])
        queues.updated(arrival.portId, existing :+ pending)

    // Phase 2 — FIFO whole-lot discharge up to each port's daily capacity.
    val (queuesAfterDischarge, inventoriesAfterDischarge) =
      ports.keys.toVector.foldLeft((queuesAfterArrivals, state.depotInventories)): (accumulator, portId) =>
        val queues = accumulator._1
        val inventories = accumulator._2
        val terminal = ports.getOrElse(
          portId,
          PortTerminal(portId, portId, ShortTons.Zero, ShortTons.Zero)
        )
        val budget = terminal.dailyDischargeCapacity.scaledBy(days.toDouble)
        val queue = queues.getOrElse(portId, Vector.empty[PendingLot])
        val (discharged, held) = dischargeFifo(queue, budget, elapsed)
        val updatedInventories = discharged.foldLeft(inventories): (inventoryMap, pending) =>
          val slot = inventoryMap.getOrElse(pending.destinationDepotId, Vector.empty[StoredLot])
          val received = StoredLot(pending.lot, Days.Zero, pending.lot.grossShortTons)
          inventoryMap.updated(pending.destinationDepotId, slot :+ received)
        (queues.updated(portId, held), updatedInventories)

    // Phase 3 — demand drawdown, FIFO by commodity within each depot.
    val inventoriesAfterDemand: Map[String, Vector[StoredLot]] =
      inventoriesAfterDischarge.map: (depotId, lots) =>
        val demands = dailyDemandTons.getOrElse(depotId, Map.empty[CommodityClass, ShortTons])
        var current = lots
        for (commodity, tons) <- demands do
          val (next, _) = drawDown(current, commodity, tons.scaledBy(days.toDouble))
          current = next
        depotId -> current

    // Phase 4 — aging under the tropical decay model.
    val inventoriesFinal: Map[String, Vector[StoredLot]] =
      inventoriesAfterDemand.map: (depotId, lots) =>
        depots.get(depotId) match
          case Some(depot) => depotId -> ageLots(depot, lots, days)
          case None        => depotId -> lots

    NetworkState(
      dayIndex = state.dayIndex + days,
      depotInventories = inventoriesFinal,
      portQueues = queuesAfterDischarge
    )

  def run(start: NetworkState, horizonDays: Int): Vector[NetworkState] =
    require(horizonDays >= 1, "horizon must be at least one day")
    Iterator.iterate(start)(advance(_, 1)).take(horizonDays + 1).toVector

  def readout(state: NetworkState): Vector[DepotReadout] =
    depots.values.toVector.map: depot =>
      val lots = state.depotInventories.getOrElse(depot.nodeId, Vector.empty[StoredLot])
      val buckets: Map[StorageCondition, ShortTons] =
        lots.groupMapReduce(stored => StorageCondition.classify(serviceableFraction(stored)))(
          _.currentShortTons
        )(_ + _)
      DepotReadout(
        depotId = depot.nodeId,
        designation = depot.designation,
        totalTons = lots.foldLeft(ShortTons.Zero)((accumulator, stored) => accumulator + stored.currentShortTons),
        serviceableTons = buckets.getOrElse(StorageCondition.Serviceable, ShortTons.Zero),
        degradedTons = buckets.getOrElse(StorageCondition.Degraded, ShortTons.Zero),
        unserviceableTons = buckets.getOrElse(StorageCondition.Unserviceable, ShortTons.Zero)
      )

  def portWaitingDays(state: NetworkState): Map[String, Days] =
    ports.map: (portId, terminal) =>
      val queuedTons = state.portQueues
        .getOrElse(portId, Vector.empty[PendingLot])
        .foldLeft(0.0)((accumulator, pending) => accumulator + pending.lot.grossShortTons.raw)
      portId -> Days(queuedTons / terminal.dailyDischargeCapacity.raw)

  private def dischargeFifo(
    queue: Vector[PendingLot],
    budget: ShortTons,
    elapsed: Days
  ): (Vector[PendingLot], Vector[PendingLot]) =
    var remainingBudget = budget.raw
    val discharged = Vector.newBuilder[PendingLot]
    val held = Vector.newBuilder[PendingLot]
    val source = queue.iterator
    var budgetExhausted = false
    while source.hasNext do
      val candidate = source.next()
      val gross = candidate.lot.grossShortTons.raw
      if !budgetExhausted && gross <= remainingBudget then
        discharged.addOne(candidate)
        remainingBudget -= gross
      else
        budgetExhausted = true
        held.addOne(candidate.copy(waitingDays = candidate.waitingDays + elapsed))
    (discharged.result(), held.result())

  private def drawDown(
    lots: Vector[StoredLot],
    commodity: CommodityClass,
    amount: ShortTons
  ): (Vector[StoredLot], ShortTons) =
    var remaining = amount.raw
    val kept = Vector.newBuilder[StoredLot]
    for stored <- lots do
      if remaining <= 0.0 || stored.lot.commodity != commodity then
        kept.addOne(stored)
      else
        val take = min(remaining, stored.currentShortTons.raw)
        remaining -= take
        val left = stored.currentShortTons.raw - take
        if left > 1e-6 then kept.addOne(stored.copy(currentShortTons = ShortTons(left)))
    (kept.result(), ShortTons(amount.raw - remaining))

  private def ageLots(depot: DepotNode, lots: Vector[StoredLot], days: Int): Vector[StoredLot] =
    lots.map: stored =>
      val alpha = decayModel.effectiveDecayRate(stored.lot.commodity, stored.lot.packaging, depot.climate)
      val survived = stored.currentShortTons.raw * exp(-alpha.raw * days.toDouble / 30.44)
      stored.copy(
        currentShortTons = ShortTons(survived),
        daysInStorage = stored.daysInStorage + Days(days.toDouble)
      )

  private def serviceableFraction(stored: StoredLot): Double =
    val gross = stored.lot.grossShortTons.raw
    if gross <= 0.0 then 0.0
    else min(1.0, stored.currentShortTons.raw / gross)

// ===========================================================================
// Section G — Historical Scenario Assembly (1944 New Guinea–Philippines axis)
// ===========================================================================

object HistoricalScenario1944:

  val depots: Map[String, DepotNode] = Map(
    "POE-SF" -> DepotNode("POE-SF", "San Francisco POE",
      ClimateProfile.SanFranciscoPoe, ShortTons(150000), ShortTons(300000), ShortTons(150000)),
    "STG-BRISBANE" -> DepotNode("STG-BRISBANE", "Base B Brisbane staging",
      ClimateProfile.BrisbaneStaging, ShortTons(180000), ShortTons(260000), ShortTons(96000)),
    "BASE-MILNE" -> DepotNode("BASE-MILNE", "Milne Bay advanced base",
      ClimateProfile.MilneBay, ShortTons(60000), ShortTons(120000), ShortTons(42000)),
    "ADV-HOLLANDIA" -> DepotNode("ADV-HOLLANDIA", "Hollandia depot complex",
      ClimateProfile.NewGuineaJungleDepot, ShortTons(85000), ShortTons(150000), ShortTons(54000)),
    "CBT-LEYTE" -> DepotNode("CBT-LEYTE", "Leyte beachhead dumps",
      ClimateProfile.LeyteBeachhead, ShortTons(40000), ShortTons(90000), ShortTons(66000))
  )

  val ports: Map[String, PortTerminal] = Map(
    "PORT-SF" -> PortTerminal("PORT-SF", "San Francisco loadout", ShortTons(4800), ShortTons.Zero),
    "PORT-BRISBANE" -> PortTerminal("PORT-BRISBANE", "Brisbane anchorage", ShortTons(3200), ShortTons.Zero),
    "PORT-MILNE" -> PortTerminal("PORT-MILNE", "Milne Bay anchorage", ShortTons(1400), ShortTons.Zero),
    "PORT-HOLLANDIA" -> PortTerminal("PORT-HOLLANDIA", "Hollandia anchorage", ShortTons(1800), ShortTons.Zero),
    "PORT-LEYTE" -> PortTerminal("PORT-LEYTE", "Leyte Gulf anchorages", ShortTons(2200), ShortTons.Zero)
  )

  val lanes: Vector[ShippingLane] = Vector(
    ShippingLane("LN-WC-BRIS", "POE-SF", "STG-BRISBANE", TransportMode.LibertyConvoy, 6300, 8.0),
    ShippingLane("LN-BRIS-MILNE", "STG-BRISBANE", "BASE-MILNE", TransportMode.CoastalLighter, 1700, 12.0),
    ShippingLane("LN-MILNE-HOLLA", "BASE-MILNE", "ADV-HOLLANDIA", TransportMode.CoastalLighter, 1100, 10.0),
    ShippingLane("LN-HOLLA-LEYTE", "ADV-HOLLANDIA", "CBT-LEYTE", TransportMode.VictoryBreakbulk, 1500, 8.0),
    ShippingLane("LN-AIR-CRIT", "POE-SF", "ADV-HOLLANDIA", TransportMode.AirTransportCmd, 6800, 60.0)
  )

  val scheduledArrivals: Map[Int, Vector[ScheduledArrival]] = Map(
    2 -> Vector(
      ScheduledArrival("PORT-BRISBANE", "STG-BRISBANE",
        StockLot("LOT-R01", CommodityClass.DrySubsistence, PackagingStandard.BarePaperboard, ShortTons(5200))),
      ScheduledArrival("PORT-BRISBANE", "STG-BRISBANE",
        StockLot("LOT-A01", CommodityClass.SmallArmsAmmo, PackagingStandard.WaxedCarton, ShortTons(2100)))
    ),
    9 -> Vector(
      ScheduledArrival("PORT-MILNE", "BASE-MILNE",
        StockLot("LOT-R02", CommodityClass.DrySubsistence, PackagingStandard.VaporproofBarrier, ShortTons(3400))),
      ScheduledArrival("PORT-MILNE", "BASE-MILNE",
        StockLot("LOT-M01", CommodityClass.MedicalSupplies, PackagingStandard.VaporproofBarrier, ShortTons(600)))
    ),
    16 -> Vector(
      ScheduledArrival("PORT-HOLLANDIA", "ADV-HOLLANDIA",
        StockLot("LOT-P01", CommodityClass.BulkPetroleum, PackagingStandard.SealedMetalContainer, ShortTons(5200))),
      ScheduledArrival("PORT-HOLLANDIA", "ADV-HOLLANDIA",
        StockLot("LOT-A02", CommodityClass.ArtilleryAmmo, PackagingStandard.SealedMetalContainer, ShortTons(2800)))
    ),
    30 -> Vector(
      ScheduledArrival("PORT-LEYTE", "CBT-LEYTE",
        StockLot("LOT-R03", CommodityClass.DrySubsistence, PackagingStandard.AsphaltLaminatedKraft, ShortTons(4600))),
      ScheduledArrival("PORT-LEYTE", "CBT-LEYTE",
        StockLot("LOT-S01", CommodityClass.SignalEquipment, PackagingStandard.VaporproofBarrier, ShortTons(900)))
    ),
    45 -> Vector(
      ScheduledArrival("PORT-HOLLANDIA", "ADV-HOLLANDIA",
        StockLot("LOT-R04", CommodityClass.DrySubsistence, PackagingStandard.WaxedCarton, ShortTons(3800)))
    )
  )

  val dailyDemandTons: Map[String, Map[CommodityClass, ShortTons]] = Map(
    "ADV-HOLLANDIA" -> Map(
      CommodityClass.DrySubsistence -> ShortTons(55),
      CommodityClass.SmallArmsAmmo -> ShortTons(18)
    ),
    "CBT-LEYTE" -> Map(
      CommodityClass.DrySubsistence -> ShortTons(70),
      CommodityClass.BulkPetroleum -> ShortTons(25)
    ),
    "BASE-MILNE" -> Map(
      CommodityClass.DrySubsistence -> ShortTons(15)
    )
  )

  val initialInventories: Map[String, Vector[StoredLot]] = Map(
    "BASE-MILNE" -> Vector(
      StoredLot(
        StockLot("SEED-M1", CommodityClass.DrySubsistence, PackagingStandard.BarePaperboard, ShortTons(3000)),
        Days(45), ShortTons(3000)
      ),
      StoredLot(
        StockLot("SEED-M2", CommodityClass.MedicalSupplies, PackagingStandard.VaporproofBarrier, ShortTons(400)),
        Days(20), ShortTons(400)
      )
    ),
    "ADV-HOLLANDIA" -> Vector(
      StoredLot(
        StockLot("SEED-H1", CommodityClass.ArtilleryAmmo, PackagingStandard.SealedMetalContainer, ShortTons(2600)),
        Days(15), ShortTons(2600)
      )
    )
  )

  def build(): PacificTheaterLogisticsSimulator =
    PacificTheaterLogisticsSimulator(
      decayModel = TropicalDecayModel.Standard,
      depots = depots,
      ports = ports,
      lanes = lanes,
      scheduledArrivals = scheduledArrivals,
      dailyDemandTons = dailyDemandTons,
      initialInventories = initialInventories
    )

// ===========================================================================
// Section H — Validation Suite
// ===========================================================================

final case class CheckResult(status: CheckStatus, description: String)

object ModelValidation:

  def runAll(): Vector[CheckResult] =
    Vector(
      booleanCheck(
        "Legacy exponential model is strictly decreasing in elapsed months",
        SpoilageDepreciationModel.remainingStock(SupplyStock(1000.0, 0.10), 3.0) <
          SpoilageDepreciationModel.remainingStock(SupplyStock(1000.0, 0.10), 1.0)
      ),
      booleanCheck(
        "Humidity coupling raises decay at 85 pct RH above the 70 pct mold threshold",
        rateFor(ClimateProfile.NewGuineaJungleDepot) > rateFor(ClimateProfile.BrisbaneStaging)
      ),
      booleanCheck(
        "Vaporproof barrier preserves more dry rations than bare paperboard after 90 jungle days",
        remainingAfter(ClimateProfile.NewGuineaJungleDepot, PackagingStandard.VaporproofBarrier) >
          remainingAfter(ClimateProfile.NewGuineaJungleDepot, PackagingStandard.BarePaperboard)
      ),
      booleanCheck(
        "Sealed metal keeps 90-day jungle losses under 10 pct",
        remainingAfter(ClimateProfile.NewGuineaJungleDepot, PackagingStandard.SealedMetalContainer) > 900.0
      ),
      booleanCheck(
        "Exclusive K-ration projection lands in the documented 15-22 lb band over 40 heavy-labor days",
        kRationProjectionWithinDocumentedBand
      ),
      booleanCheck(
        "Port FIFO discharge cannot drive backlog negative",
        portFifoNeverNegative
      ),
      booleanCheck(
        "Condition classifier respects inspection thresholds",
        StorageCondition.classify(0.86) == StorageCondition.Serviceable &&
          StorageCondition.classify(0.60) == StorageCondition.Degraded &&
          StorageCondition.classify(0.40) == StorageCondition.Unserviceable
      ),
      booleanCheck(
        "Relative humidity factory rejects physically impossible inputs",
        Try(RelativeHumidity.percent(120.0)).isFailure
      )
    )

  private def rateFor(climate: ClimateProfile): Double =
    TropicalDecayModel.Standard
      .effectiveDecayRate(CommodityClass.DrySubsistence, PackagingStandard.BarePaperboard, climate)
      .raw

  private def remainingAfter(climate: ClimateProfile, packaging: PackagingStandard): Double =
    val depot = DepotNode("CHK", "validation site", climate, ShortTons(10000), ShortTons(10000), ShortTons(1000))
    val lot = StoredLot(
      StockLot("CHK-1", CommodityClass.DrySubsistence, packaging, ShortTons(1000)),
      Days.Zero,
      ShortTons(1000)
    )
    TropicalDecayModel.Standard.remainingTons(lot, depot, Days(90.0)).raw

  private def kRationProjectionWithinDocumentedBand: Boolean =
    val loss = FieldDietModel.projectedWeightLossLbs(RationType.KRation, heavyLabor = true, Days(40.0))
    loss >= 15.0 && loss <= 22.0

  private def portFifoNeverNegative: Boolean =
    val terminal = PortTerminal("T", "Test anchorage", ShortTons(50), ShortTons.Zero).admit(ShortTons(120))
    val (afterFirst, moved1) = terminal.clear(Days(1))
    val (afterSecond, moved2) = afterFirst.clear(Days(1))
    val (afterThird, moved3) = afterSecond.clear(Days(1))
    moved1.raw == 50.0 && moved2.raw == 50.0 && moved3.raw == 20.0 &&
      afterThird.backlogShortTons.raw == 0.0

  private def booleanCheck(description: String, holds: Boolean): CheckResult =
    CheckResult(if holds then CheckStatus.Pass else CheckStatus.Fail, description)

// ===========================================================================
// Section I — Legacy Compatibility API (retained from base specification)
// ===========================================================================

final case class SupplyStock(initialTons: Double, decayRate: Double)

object SpoilageDepreciationModel:
  def remainingStock(stock: SupplyStock, months: Double): Double =
    if months < 0.0 || stock.decayRate < 0.0 then stock.initialTons
    else stock.initialTons * exp(-stock.decayRate * months)

// ===========================================================================
// Section J — Executable Demonstration
// ===========================================================================

@main def pacificDemo(): Unit =

  val sim = HistoricalScenario1944.build()

  println("== Pacific Theater Tropical-Decay Simulation: 120-day horizon ==")

  sim.lanes.foreach: lane =>
    println(
      f"Lane ${lane.laneId}%-24s ${lane.distanceNauticalMiles}%5d nm at ${lane.mode.knots}%5.1f kn" +
        f" -> transit ${lane.transitDays.raw}%5.1f d, monthly lift ${lane.monthlyLiftCapacity.raw}%8.0f short tons"
    )

  val trajectory = sim.run(sim.initialState(), 120)

  trajectory.foreach: snapshot =>
    if snapshot.dayIndex % 30 == 0 then
      println(f"-- Day ${snapshot.dayIndex}%4d --")
      sim.readout(snapshot).foreach: r =>
        println(
          f"  ${r.designation}%-26s total ${r.totalTons.raw}%9.1f t" +
            f" | serviceable ${r.serviceableTons.raw}%9.1f" +
            f" | degraded ${r.degradedTons.raw}%8.1f" +
            f" | unserviceable ${r.unserviceableTons.raw}%8.1f"
        )
      sim.portWaitingDays(snapshot).foreach: (portId, wait) =>
        println(f"  port ${portId}%-16s queue wait ${wait.raw}%5.1f days")

  val troops = TroopPopulation("Reference reinforced division", 15000, 155.0)
  val dietLoss = FieldDietModel.projectedWeightLossLbs(RationType.KRation, heavyLabor = true, Days(40.0))
  val effectiveness =
    FieldDietModel.combatEffectivenessIndex(troops.meanBodyWeightLbs - dietLoss, troops.meanBodyWeightLbs)
  println(
    f"Diet model: 40 days on exclusive K rations, heavy labor -> -${dietLoss}%.1f lb/man," +
      f" combat-effectiveness index ${effectiveness}%.2f"
  )

  val checks = ModelValidation.runAll()
  val passed = checks.count(_.status == CheckStatus.Pass)
  println(s"Model validation: $passed of ${checks.size} checks passed")
  checks.foreach: c =>
    println(s"  [${c.status}] ${c.description}")
```

**Engineering notes.** The module preserves the mandated base API (`SupplyStock`, `SpoilageDepreciationModel.remainingStock`) verbatim, then layers the typed architecture above it: five `opaque type` units eliminate dimensional errors; four `enum`s encode the commodity, packaging, condition, and transport domains; the simulator executes the four-phase daily transition (arrivals → port FIFO discharge → demand drawdown → environment-coupled decay) as pure state transitions over immutable snapshots. The validation suite self-tests the calibration: the sealed-metal check confirms the <10% ninety-day loss band, and the diet check confirms the 15–22 lb documented band, both against the constants of §2.

---

### 6. Graduate-Level Operational Analysis

#### 6.1 How the Absence of Refrigerated Storage Limited Diet and Morale in the Southwest Pacific

**The physical scarcity.** Refrigerated hulls were the scarcest species of Allied shipping. Mechanically complex, thermally expensive, and slow to convert, reefer tonnage never approached a tenth of dry-cargo capacity, while the fresh-ration entitlement of a million-man theater implied a double-digit share. The deficit was structural, not managerial: every reefer committed to the South Pacific was one withheld from the domestic economy, the North Atlantic run, or hospital ship employment, and the Combined Boards never generated a formula that satisfied all claimants. Ashore the story repeated itself — cold-storage warehouses are civil infrastructure, and there was none east of Brisbane worth the name until aviation engineers and base-section builders erected ice plants at Hollandia and, later, Leyte. The consequence was a theater in which "fresh" was a memory: meat arrived frozen-thawed-refrozen or not at all; produce arrived as dehydrated flakes; milk arrived as powder; and the reefer trickle that did arrive was consumed disproportionately at general-officer messes and hospitals — a distribution fact that did not escape enlisted notice.

**The physiological transmission mechanism.** The damage ran through the energy ledger formalized in §4 M6. The K ration supplied 2,830 kcal against a heavy-labor expenditure of ~4,400 kcal — a 1,570 kcal/day deficit that the body settled at 3,500 kcal per pound of adipose: $\dot w = -1570/3500 = -0.449$ lb/day, hence the documented 15–22 lb losses over 30–45 days (P-15). The C ration closed the caloric gap but at 6 lb/man-day doubled the transport burden relative to the K: the theater faced an explicit *calorie-per-transport-ton frontier* —

$$
\text{kcal per lb lifted:}\quad K = \frac{2830}{2.75} = 1029,\quad C = \frac{3300}{6.0} = 550,\quad J = \frac{3430}{4.0} = 858
$$

— and the dehydrated Jungle ration dominated that frontier, yet failed in the field. Why? Because the frontier equation omits the *behavioral* term. Men do not eat kilocalories; they eat meals. After roughly three weeks of monotony, acceptance collapsed — troops discarded components, traded them to natives, or simply under-consumed — so effective intake must be modeled as $c_{\text{eff}} = \eta_{\text{acc}} \cdot c_{\text{nominal}}$, with $\eta_{\text{acc}}$ decaying toward ~0.7–0.85 on repetitive diets. Fresh food, hot food, and variety were not luxuries; they were the maintenance protocol for $\eta_{\text{acc}}$ itself. This is the deepest sense in which the reefer shortage was a *combat-power* shortage: refrigerated tonnage purchased acceptability, and acceptability purchased calories actually ingested.

**The morale channel.** Wartime survey research (the Stouffer tradition) consistently ranked food and mail among the dominant determinants of enlisted morale, ahead of many factors commanders judged more "military." A hot meal is a ritual of unit cohesion — the moment a squad reassembles as a social organism — and its absence for months at a time imposed a slow tax on cohesion that no citation could offset. Commanders understood the exchange rate intuitively: MacArthur's headquarters famously secured high-priority allocations of beer to the Southwest Pacific in 1943, defending the tonnage against incredulous Washington staff on explicitly morale-economic grounds. The beer and the missing reefers belong to the same optimization problem: maximize $\Psi$ (effectiveness, M6) subject to hull capacity, where a case of beer and a crate of chilled lettuce occasionally dominate a crate of .30-caliber ball at the margin.

**Operational consequences and mitigations.** The composite syndrome — caloric deficit, vitamin shortfall (ascorbic acid deficiency degrading wound healing and fatigue resistance), and disease synergy (malaria, dysentery, and malnutrition reinforcing one another) — measurably shortened patrol radii, degraded night-vigilance performance, and slowed return to duty. The theater's countermeasures traced the full logistics toolkit: citrus concentrate and fortified commodities in the subsistence block; occasional fresh-and-freeze runs from Australia and New Zealand when hulls permitted; shore ice plants and cold storage as base-development priorities from 1944; local purchase of native produce; and finally the 10-in-1 group ration, whose mess-kit cookery restored some of the social function of eating. For the simulator, the design imperative is coupling: the diet state $(w, \eta_{\text{acc}})$ must feed the effectiveness multiplier $\Psi$ that weights allocation priorities in M5 — closing the loop between a refrigeration decision made in Washington and a patrol that turns back short of its objective in the Finisterres.

#### 6.2 Packaging Innovations Against Moisture: From Failure Reports to Materials Science

**The failure physics.** Three mechanisms destroyed Pacific cargo. First, *hygroscopic equilibrium*: paperboard and kraft equilibrate with ambient humidity, and at 85% RH (P-01) they became wicks, transporting moisture into contents whose own spoilage followed the exponential law of M1 once surface humidity exceeded the ~70% germination threshold (P-04). Second, *electrochemical corrosion*: above ~75% RH with marine salt contamination, time-of-wetness drove rust through tinplate and into cartridge cases, and propellant — nitrocellulose being mildly hygroscopic — absorbed moisture until ballistic performance drifted and misfires multiplied. Third, *transient immersion*: surf offload and deck wash subjected materiel to outright saltwater soaking, a step-input no ventilated package survives. The 1942 survey record — 30–60% losses on paper-packed subsistence within ninety equatorial days (P-06) — was the empirical indictment.

**The institutional and technological response.** The remedy proceeded through three stages. (1) *Centralization*: in 1943 the ASF consolidated packaging responsibility, with the Quartermaster Subsistence Research Laboratory (Chicago) driving food specifications and Ordnance arsenal laboratories the ammunition side — ending the pre-war regime in which packaging was a procurement afterthought. (2) *The barrier ladder*: engineers ranked materials by moisture-vapor transmission and deployed them by value-at-risk — wax-dipped cartons (paraffin–microcrystalline blends), asphalt-laminated kraft barrier board, Pliofilm (rubber hydrochloride) and Saran (PVDC) flexible films, lacquered tinplate, and ultimately foil laminates and hermetic metal. Around these accrued the supporting cast: silica-gel desiccant sized to enclosure volume and barrier permeability, and cobalt-chloride humidity-indicator cards (blue when dry, pink when hydrated) that turned every sealed container into a self-reporting sensor. Textiles received Cu-8 fungicidal impregnation; weapons went ashore in pack-waterproofing bags; signal equipment traveled in heat-sealed barrier bags with desiccant; ammunition migrated from rot-prone wooden boxes into sealed metal containers of the M19-series with bituminous seals and lined propellant enclosures. (3) *Qualification science*: acceptance required surviving standardized torture — cyclic damp-heat chambers (order of 120 °F at 95% RH), mixed-spore fungal chambers inoculated with *Aspergillus*, *Penicillium*, and cellulolytic molds, salt-spray exposure, and rough-handling and parachute-drop sequences. Two medical achievements deserve separate honors: lyophilized plasma, stable for years at tropical ambient temperatures, converted transfusion from an impossibility forward of a base hospital into a routine of the aid station; and sealed tablet packaging protected the Atabrine supply on which the theater's malaria victory (P-25/P-26) partly rested.

**The economics of protection — a breakeven theorem.** Protection is not free: vaporproof systems added 8–30% gross weight (P-27), and in a shipping-scarce theater weight is the currency. Let $\ell_b$ and $\ell_p$ denote bare and protected loss fractions and $p$ the packaging weight penalty. Delivered net tonnage favors protection precisely when

$$
\frac{1-\ell_p}{1+p} \;>\; 1-\ell_b
\qquad\Longleftrightarrow\qquad
\ell_b - \ell_p \;>\; p\,(1-\ell_p)
$$

Calibrate with the simulator's constants: $p = 0.21$, $\ell_p = 0.08$ ⟹ protection pays whenever bare losses exceed $\approx 27\%$. Moreover, in M5 the relevant penalty is inflated by the shadow price of shipping, $\lambda_{\text{lift}} > 0$, raising the threshold further — which elegantly explains the historical pattern: low-value, high-bulk engineer cargo rode bare or minimally protected, while subsistence, ammunition, medical, and signal items ascended the barrier ladder. Optimal packaging depth is therefore a discrete selection per commodity-climate cell: choose the cheapest rung of the ladder whose predicted loss clears the breakeven inequality — exactly the decision the `PackagingStandard` enumeration encodes.

**Measured outcomes and legacy.** The program worked. By 1944, V-packed subsistence lots in equatorial storage showed losses under ~10% (P-07/P-08) against the 30–60% of two years earlier; shelf life extended from roughly three months to a year; ammunition complaint rates fell; plasma arrived essentially loss-free. The deeper legacy is institutional: the specification-and-test apparatus born of these failure reports descends directly into MIL-STD packaging families and ASTM distribution-cycling practice; hermetic #10-can storage, retort-pouch combat rations, conformal-coated electronics, and foil-blister pharmaceuticals are all children of the SWPA dump surveys. The chapter's quietest lesson remains its most modern: in any expeditionary campaign, *the package is part of the weapon system* — a force multiplier manufactured not in arsenals but in paper mills, wax works, and laminating plants, and validated not in proofs but in the mold-counts of jungle warehouses.
