import { Component, OnInit } from '@angular/core';
import { NetworkService } from '../../../services/network.service'
import * as Highcharts from 'highcharts';
import { CampaignProfileConnection } from "../../../models/campaign-profile-connection/CampaignProfileConnection";

declare var require: any;

let HighChartsNetworkgraph = require('highcharts/modules/networkgraph');
let HighChartsExporting = require('highcharts/modules/exporting');


HighChartsNetworkgraph(Highcharts);
HighChartsExporting(Highcharts);


@Component({
  selector: 'app-overview',
  templateUrl: './overview.component.html',
  styleUrls: ['./overview.component.css']
})
export class OverviewComponent implements OnInit {
  Highcharts: typeof Highcharts = Highcharts;
  title = 'app';
  chart : any;
  updateFromInput = false;
  chartConstructor = "chart";
  chartCallback : any;
  chartOptions : Highcharts.Options = {
    chart: {
      type: "networkgraph",
      plotBorderWidth: 2,
      plotBackgroundColor: '#eee',
      plotShadow: true,
      height: "100%",
      width: 1600,
      margin: 0,
      backgroundColor: 'rgba(0,0,0,0)'
    },
    title: {
      text: "Network Overview"
    },
    subtitle: {
      text: "A view of profiles and campaigns alike"
    },
    plotOptions: {
      networkgraph: {
        cropThreshold: 600,
        keys: ["from", "to"],
        layoutAlgorithm: {
          enableSimulation: true,
          friction: -0.9,
          linkLength: 6,
          integration: 'verlet',
          attractiveForce: function (d, k) {
              return Math.max(-(d * d) / (k * 400), -100);
          },
          repulsiveForce: function (d, k) {
              return Math.min((k * k) / (d), 100);
          }
        }
        
      }
    },
    series: [
      {
        marker: {
          radius: 10
        },
        dataLabels: {
          enabled: true
        },
        data: [
       
        ],
       
        type: 'networkgraph'
      }
    ]
  };
 
  overviewConnections : CampaignProfileConnection[] = [];
 
  constructor(private networkService: NetworkService) { 

    this.networkService.getOverviewConnections().subscribe(connections => {
      this.overviewConnections = connections;

     /* this.overviewConnections.forEach(connect => {
        const row = [
          connect.endOne.tagline,
          connect.endTwo.name
        ]
        this.chartOptions.series[0]['data'].push(row);
       
      });*/
      const size = this.overviewConnections.length;
      console.log(size);
      for(var i = size -1 ; i >= 0; i--){
        
        const row = [
          this.overviewConnections[i]['endOne'].tagline,
          this.overviewConnections[i].endTwo.name
        ];
        this.chartOptions.series[0]['data'].push(row);
      }
      
      Highcharts.chart('container', this.chartOptions);
    });

    const self = this;

    this.chartCallback = chart => {
      self.chart = chart;
    }
  }

  ngOnInit() {
    
  }

  

}
