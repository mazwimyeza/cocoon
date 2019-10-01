import { Component, OnInit } from '@angular/core';
import * as Highcharts from 'highcharts'
import { HttpClient } from '@angular/common/http'
import { interval, Subscription } from 'rxjs';


declare var require: any;
let Boost = require('highcharts/modules/boost');
let noData = require('highcharts/modules/no-data-to-display');
let More = require('highcharts/highcharts-more');

Boost(Highcharts);
noData(Highcharts);
More(Highcharts);



@Component({
  selector: 'app-campaign-sentiment',
  templateUrl: './campaign-sentiment.component.html',
  styleUrls: ['./campaign-sentiment.component.css']
})
export class CampaignSentimentComponent implements OnInit {
  public options: any =  {
    chart: {
      type: 'line',
      height: 700
    },
    title: {
      text: 'Overview - scatter plot'
    },
    credits: {
      enabled: false
    },
    tooltip: {
      formatter: function(){
        return 'x: ' + Highcharts.dateFormat('%e %b %y %H:%M:%S', this.x) +
        'y: ' + this.y.toFixed(2);
      }
    },
    xAxis: {
      type: 'datetime',
      labels: {
        formatter:function(){
          return Highcharts.dateFormat('%e %b %y', this.value);
        }
      }
    },
    series: [
      {
        name: 'Normal',
        turboThreshold: 500000,
        data: []
      },
      {
        name: 'Abnormal',
        turboThreshold: 500000,
        data: []
      }
    ]
  }

  subscription: Subscription;
  constructor(private http: HttpClient) { }

  ngOnInit() {
    const source = interval(10000);

    const apiLink = 'https://api.myjson.com/bins/13lnf4';

    this.subscription = source.subscribe(val => this.getApiResponse(apiLink).then(
      data => {
        const updated_normal_data = [];
        const updated_abnormal_data = [];

        data.forEach(row => {
          const temp_row = [
            new Date(row.timestamp).getTime(),
            row.value
          ];
          row.Normal === 1 ? updated_normal_data.push(temp_row) : updated_abnormal_data.push(temp_row);
        });
        this.options.series[0]['data'] = updated_normal_data;
        this.options.series[1]['data'] = updated_abnormal_data;
        Highcharts.chart('container', this.options);
      },
      error => {
        console.log("something went wrong");
      }
    ));

    
  }

  getApiResponse(url){
    return this.http.get<any>(url, {}).toPromise()
    .then(res => {
      return res;
    })
  }

}
