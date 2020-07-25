import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductServices } from 'src/app/services/product.services';

@Component({
  selector: 'app-details-products',
  templateUrl: './details-products.component.html',
  styleUrls: ['./details-products.component.css']
})
export class DetailsProductsComponent implements OnInit {
  id: number;
  product: Product;
  constructor(private route: ActivatedRoute, private router: Router,
    private productService: ProductServices) { }
  ngOnInit() {
    this.product = new Product();
    this.id = this.route.snapshot.params['id'];
    this.productService.getProduct(this.id)
      .subscribe(data => {
        console.log(data)
        this.product = data;
      }, error => console.log(error));
  }
  list() {
    this.router.navigate(['home']);
  }
}
