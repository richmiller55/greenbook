// scala 3

// Define case classes without braces using single lines or indentation
case class ModelMetrics(name: String, cost: Double, requests: Int, tokens: Long)
case class ModelPercentages(name: String, costPct: Double, requestPct: Double, tokenPct: Double)

@main def calculatePercentages(): Unit =
  // 1. Input Data
  val modelsData = List(
    ModelMetrics("anthropic/claude-4.8-opus-20260528", cost = 120.50, requests = 1500, tokens = 4500000L),
    ModelMetrics("moonshotai/kimi-k2-thinking",        cost = 45.20,  requests = 2200, tokens = 3100000L),
    ModelMetrics("deepseek/deepseek-v4-flash-0731",   cost = 12.80,  requests = 5800, tokens = 8900000L),
    ModelMetrics("openai/gpt-5.6-sol",                 cost = 95.00,  requests = 3100, tokens = 6200000L)
  )

  // 2. Calculate Totals
  val totalCost     = modelsData.map(_.cost).sum
  val totalRequests = modelsData.map(_.requests).sum.toDouble
  val totalTokens   = modelsData.map(_.tokens).sum.toDouble

  // 3. Compute Percentages using braceless map block and then/else
  val results = modelsData.map: m =>
    val cPct = if totalCost > 0 then (m.cost / totalCost) * 100 else 0.0
    val rPct = if totalRequests > 0 then (m.requests / totalRequests) * 100 else 0.0
    val tPct = if totalTokens > 0 then (m.tokens / totalTokens) * 100 else 0.0
    ModelPercentages(m.name, cPct, rPct, tPct)

  // 4. Print structured results to the console
  println("=" * 115)
  println(f"${"Model Name"}%-40s | ${"Cost %"}%-15s | ${"Requests %"}%-15s | ${"Tokens %"}%-15s")
  println("=" * 115)
  
  // Braceless foreach loop
  for r <- results do
    println(f"${r.name}%-40s | ${r.costPct}%-13.2f%% | ${r.requestPct}%-13.2f%% | ${r.tokenPct}%-13.2f%%")
    
  println("=" * 115)
