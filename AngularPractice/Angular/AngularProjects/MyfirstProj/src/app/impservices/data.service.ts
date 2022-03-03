import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  //dataServiceProp: string = 'welcome to Everyone!';
  //private behavSubj = new BehaviorSubject(this.dataServiceProp);
  //currentData = this.behavSubj.asObservable()
  //changeData(data: any) {
  //  this.behavSubj.next(data)
  //}

  pProductList: any[] = [
    { proId: 101, proName: 'Samsung', proPrice: 20, proDescription: '4K video recording at 30 fps', proImage: "../assets/sam.jpg" },
    { proId: 102, proName: 'Vivo', proPrice: 40, proDescription: 'High CRI LED Flash', proImage: "../assets/vivo.jfif" },
    { proId: 103, proName: 'Oppo', proPrice: 30, proDescription: 'Hyperlapse video with stabilization', proImage: "../assets/oppo.jfif" },
    { proId: 104, proName: 'Iphone', proPrice: 50, proDescription: 'face detection', proImage: "../assets/iphone.jfif" },
    { proId: 105, proName: 'Lenovo', proPrice: 60, proDescription: 'Continuous autofocus video', proImage: "../assets/lenovo.png" },
   
   ]
  private behavSubj = new BehaviorSubject(this.pProductList);
  currentData = this.behavSubj.asObservable()
  changeData(data: any[]) {
    this.behavSubj.next(data)
  }
}
