using Microsoft.EntityFrameworkCore.Migrations;

namespace WEBAPPENTITY.Migrations
{
    public partial class CreatteSP : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            var sp1 = @"Create Procedure SelectAllProducts
                       as 
                        begin
                        select *from Products
                       end";
            var sp2 = @"Create Procedure SelectproductByID
                       @Id int
                       as 
                        begin
                        select *from Products
                       where ProductId=@Id
                       end";
            var sp3 = @"Create Procedure AddProduct
                       @Id int, @Name varchar(40),@Price real
                       as 
                        begin
                        insert into Products(Name,Price) values (@Name,@Price)
                       end";
            var sp4 = @"Create Procedure UpdateProduct
                       @Id int, @Name varchar(40),@Price real
                       as 
                        begin
                        Update  Products set Name =@Name , Price =@Price
                        Where ProductId=@Id
                       end";
            var sp5 = @"Create Procedure DeleteProduct
                       @Id int
                       as 
                        begin
                         Delete from Products
                        Where ProductId=@Id
                       end";
            migrationBuilder.Sql(sp1);
            migrationBuilder.Sql(sp2);
            migrationBuilder.Sql(sp3);
            migrationBuilder.Sql(sp4);
            migrationBuilder.Sql(sp5);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {

        }
    }
}
