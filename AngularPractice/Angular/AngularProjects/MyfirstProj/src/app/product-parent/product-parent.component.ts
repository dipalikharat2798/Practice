import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product-parent',
  templateUrl: './product-parent.component.html',
  styleUrls: ['./product-parent.component.css']
})
export class ProductParentComponent {
  pProductList: any[] = [
    { proId: 101, proName: 'Samsung', proPrice: 2000, proDescription: '4K video recording at 30 fps', proImage: "../assets/sam.jpg" },
    { proId: 102, proName: 'Vivo', proPrice: 4000, proDescription: 'High CRI LED Flash', proImage: "../assets/vivo.jfif" },
    { proId: 103, proName: 'Oppo', proPrice: 3000, proDescription: 'Hyperlapse video with stabilization', proImage: "../assets/oppo.jfif" },
    { proId: 104, proName: 'Iphone', proPrice: 5000, proDescription: 'face detection', proImage: "../assets/iphone.jfif" },
    { proId: 105, proName: 'Lenovo', proPrice: 6000, proDescription: 'Continuous autofocus video', proImage: "../assets/lenovo.png" },
    { proId: 105, proName: 'Lenovo', proPrice: 6000, proDescription: 'Continuous autofocus video', proImage: "../assets/lenovo.png" },

  ]
}
