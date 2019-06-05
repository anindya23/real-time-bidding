### Real-Time-Bidding (RTB Project with Scala & Akka)
#### Sample Bid Request
```
{
	"id": "201",
	"imp": [
		{"id": "201", "wmin": 50, "wmax": 100, "w": 75, "hmin": 50, "hmax": 100, "h": 75, "bidFloor": 0.5},
		{"id": "202", "wmin": 30, "wmax": 70, "w": 45, "hmin": 30, "hmax": 70, "h": 45, "bidFloor": 0.3}
	],
	"site": {"id": 301, "domain": "www.google.com"},
	"user": {
		"id": "401",
		"geo": {
			"country": "Bangladesh",
			"city": "Dhaka",
			"lat": 23.8103,
			"lon": 90.4125
		}
	},
	"device": {
		"id": "501",
		"geo": {
			"country": "Bangladesh",
			"city": "Paro",
			"lat": 23.8103,
			"lon": 90.4125
		}
	}
}
```
