import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { Router, ActivatedRoute } from '@angular/router';
import { ProductServices } from 'src/app/services/product.services';

@Component({
  selector: 'app-update-products',
  templateUrl: './update-products.component.html',
  styleUrls: ['./update-products.component.css']
})
export class UpdateProductsComponent implements OnInit {

  id: number;
  product: Product;
  submitted = false;
  constructor(private route: ActivatedRoute,private router: Router,
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

  updateProduct() {
    this.productService.updateProduct(this.id, this.product)
      .subscribe(data => console.log(data), error => console.log(error));
    this.product = new Product();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.updateProduct();    
  }

  gotoList() {
    this.router.navigate(['/products']);
  }

}
