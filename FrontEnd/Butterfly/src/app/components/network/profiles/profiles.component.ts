import { Component, OnInit } from '@angular/core';
import { ProfileConnection } from '../../../models/profile-connection/profile-connection.module'
import { NetworkService } from '../../../services/network.service'
import * as Highcharts from 'highcharts';

declare var require: any;

let HighChartsNetworkgraph = require('highcharts/modules/networkgraph');
let HighChartsExporting = require('highcharts/modules/exporting');


HighChartsNetworkgraph(Highcharts);
HighChartsExporting(Highcharts);

@Component({
  selector: 'app-profiles',
  templateUrl: './profiles.component.html',
  styleUrls: ['./profiles.component.css']
})
export class ProfilesComponent implements OnInit {

  Highcharts: typeof Highcharts = Highcharts;
  title = 'app';
  chart : any;
  updateFromInput = false;
  chartConstructor = "chart";
  chartCallback : any;
  chartOptions : Highcharts.Options = {
    chart: {
      type: "networkgraph",
      height: "100%",
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
        keys: ["from", "to"],
        layoutAlgorithm: {
          enableSimulation: true,
          repulsiveForce: function() {
            return 180;
          }
        }
        
      }
    },
    series: [
      {
        dataLabels: {
          enabled: true
        },
        data: [
       
        ],
        type: 'networkgraph'
      }
    ]
  };
 
  profileConnections : ProfileConnection[] = [];
 
  constructor(private networkService: NetworkService) { 

    this.networkService.getProfileConnections().subscribe(connections => {
      this.profileConnections = connections;
      console.log("connections in: "+this.profileConnections);

      this.profileConnections.forEach(connect => {
        const row = [
          connect.endOne.name,
          connect.endTwo.name
        ]
        this.chartOptions.series[0]['data'].push(row);
        console.log(connect.endOne.name +", "+connect.endTwo.name);
      });
      console.log("series: ")
      console.log(this.chartOptions.series[0]['data']);
      Highcharts.chart('container', this.chartOptions);
    });
   
    console.log("connections out: "+this.profileConnections);
    console.log(this.chartOptions.series[0]['data']);

    const self = this;

    this.chartCallback = chart => {
      self.chart = chart;
    }
  }

  ngOnInit() {
    
  }

}
