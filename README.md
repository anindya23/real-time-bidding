### Real-Time-Bidding (RTB Project with Scala & Akka)
URL: <http://127.0.0.1:9090/bidding>
#### Sample Bid Request with Status Code 200
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
#### Sample Bid Response with Status Code 200
```
{
    "adid": "Adid Done",
    "banner": {
        "height": 50,
        "id": 1,
        "src": "Source1",
        "width": 100
    },
    "bidRequestId": "201",
    "id": "1001",
    "price": 8.5
}
```

#### Sample Bid Request with Status Code 204 (No Content)
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
			"country": "India",
			"city": "Delhi",
			"lat": 23.8103,
			"lon": 90.4125
		}
	},
	"device": {
		"id": "501",
		"geo": {
			"country": "Sweden",
			"city": "Stockholm",
			"lat": 23.8103,
			"lon": 90.4125
		}
	}
}
```

