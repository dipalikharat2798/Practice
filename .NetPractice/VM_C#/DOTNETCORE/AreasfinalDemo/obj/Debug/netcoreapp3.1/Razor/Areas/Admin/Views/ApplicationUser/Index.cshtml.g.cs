#pragma checksum "C:\Users\dipalik\Music\VM_C#\DOTNETCORE\AreasfinalDemo\Areas\Admin\Views\ApplicationUser\Index.cshtml" "{ff1816ec-aa5e-4d10-87f7-6f4963833460}" "f39f22606b3b7aaadbc774a054c401577482c1e6"
// <auto-generated/>
#pragma warning disable 1591
[assembly: global::Microsoft.AspNetCore.Razor.Hosting.RazorCompiledItemAttribute(typeof(AspNetCore.Areas_Admin_Views_ApplicationUser_Index), @"mvc.1.0.view", @"/Areas/Admin/Views/ApplicationUser/Index.cshtml")]
namespace AspNetCore
{
    #line hidden
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Threading.Tasks;
    using Microsoft.AspNetCore.Mvc;
    using Microsoft.AspNetCore.Mvc.Rendering;
    using Microsoft.AspNetCore.Mvc.ViewFeatures;
#nullable restore
#line 1 "C:\Users\dipalik\Music\VM_C#\DOTNETCORE\AreasfinalDemo\Areas\Admin\Views\_ViewImports.cshtml"
using AreasfinalDemo;

#line default
#line hidden
#nullable disable
#nullable restore
#line 2 "C:\Users\dipalik\Music\VM_C#\DOTNETCORE\AreasfinalDemo\Areas\Admin\Views\_ViewImports.cshtml"
using AreasfinalDemo.Models;

#line default
#line hidden
#nullable disable
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"f39f22606b3b7aaadbc774a054c401577482c1e6", @"/Areas/Admin/Views/ApplicationUser/Index.cshtml")]
    [global::Microsoft.AspNetCore.Razor.Hosting.RazorSourceChecksumAttribute(@"SHA1", @"5ae6e5b0970ec99057b7d367ed05309697ec8f69", @"/Areas/Admin/Views/_ViewImports.cshtml")]
    public class Areas_Admin_Views_ApplicationUser_Index : global::Microsoft.AspNetCore.Mvc.Razor.RazorPage<IEnumerable<AreasfinalDemo.Models.AppliccationUser>>
    {
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_0 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("asp-area", "Identity", global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_1 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("asp-page", "/Account/Register", global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_2 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("class", new global::Microsoft.AspNetCore.Html.HtmlString("btn btn-info"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_3 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("type", new global::Microsoft.AspNetCore.Html.HtmlString("button"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_4 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("class", new global::Microsoft.AspNetCore.Html.HtmlString("btn btn-primary"), global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        private static readonly global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute __tagHelperAttribute_5 = new global::Microsoft.AspNetCore.Razor.TagHelpers.TagHelperAttribute("asp-action", "Edit", global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
        #line hidden
        #pragma warning disable 0649
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperExecutionContext __tagHelperExecutionContext;
        #pragma warning restore 0649
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperRunner __tagHelperRunner = new global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperRunner();
        #pragma warning disable 0169
        private string __tagHelperStringValueBuffer;
        #pragma warning restore 0169
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager __backed__tagHelperScopeManager = null;
        private global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager __tagHelperScopeManager
        {
            get
            {
                if (__backed__tagHelperScopeManager == null)
                {
                    __backed__tagHelperScopeManager = new global::Microsoft.AspNetCore.Razor.Runtime.TagHelpers.TagHelperScopeManager(StartTagHelperWritingScope, EndTagHelperWritingScope);
                }
                return __backed__tagHelperScopeManager;
            }
        }
        private global::Microsoft.AspNetCore.Mvc.TagHelpers.AnchorTagHelper __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper;
        #pragma warning disable 1998
        public async override global::System.Threading.Tasks.Task ExecuteAsync()
        {
#nullable restore
#line 2 "C:\Users\dipalik\Music\VM_C#\DOTNETCORE\AreasfinalDemo\Areas\Admin\Views\ApplicationUser\Index.cshtml"
  
    ViewData["Title"] = "Index";
    Layout = "~/Views/Shared/_Layout.cshtml";

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n<h1>Index</h1>\r\n\r\n\r\n\r\n<br />\r\n<br />\r\n\r\n\r\n\r\n<div class=\"row\">\r\n    <div class=\"col-6\">\r\n        <h2 class=\"text-info\"> Admin Users List</h2>\r\n    </div>\r\n    <div class=\"col-6 text-right\">\r\n        ");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("a", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "f39f22606b3b7aaadbc774a054c401577482c1e65730", async() => {
                WriteLiteral("<i class=\"fas fa-plus\"></i>&nbsp; New Admin User");
            }
            );
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.TagHelpers.AnchorTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper);
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.Area = (string)__tagHelperAttribute_0.Value;
            __tagHelperExecutionContext.AddTagHelperAttribute(__tagHelperAttribute_0);
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.Page = (string)__tagHelperAttribute_1.Value;
            __tagHelperExecutionContext.AddTagHelperAttribute(__tagHelperAttribute_1);
            __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_2);
            await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
            if (!__tagHelperExecutionContext.Output.IsContentModified)
            {
                await __tagHelperExecutionContext.SetOutputContentAsync();
            }
            Write(__tagHelperExecutionContext.Output);
            __tagHelperExecutionContext = __tagHelperScopeManager.End();
            WriteLiteral("\r\n    </div>\r\n</div>\r\n\r\n\r\n\r\n<br />\r\n<div>\r\n    <table class=\"table table-striped border\">\r\n        <tr class=\"table-info\">\r\n            <th>\r\n                ");
#nullable restore
#line 32 "C:\Users\dipalik\Music\VM_C#\DOTNETCORE\AreasfinalDemo\Areas\Admin\Views\ApplicationUser\Index.cshtml"
           Write(Html.DisplayNameFor(m => m.Name));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n            </th>\r\n            <th>\r\n                ");
#nullable restore
#line 35 "C:\Users\dipalik\Music\VM_C#\DOTNETCORE\AreasfinalDemo\Areas\Admin\Views\ApplicationUser\Index.cshtml"
           Write(Html.DisplayNameFor(m => m.Email));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n            </th>\r\n            <th>\r\n                ");
#nullable restore
#line 38 "C:\Users\dipalik\Music\VM_C#\DOTNETCORE\AreasfinalDemo\Areas\Admin\Views\ApplicationUser\Index.cshtml"
           Write(Html.DisplayNameFor(m => m.PhoneNumber));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n            </th>\r\n            <th>\r\n                Disabled\r\n            </th>\r\n            <th></th>\r\n        </tr>\r\n\r\n\r\n\r\n");
#nullable restore
#line 48 "C:\Users\dipalik\Music\VM_C#\DOTNETCORE\AreasfinalDemo\Areas\Admin\Views\ApplicationUser\Index.cshtml"
         foreach (var item in Model)
        {

#line default
#line hidden
#nullable disable
            WriteLiteral("            <tr>\r\n                <td>\r\n                    ");
#nullable restore
#line 52 "C:\Users\dipalik\Music\VM_C#\DOTNETCORE\AreasfinalDemo\Areas\Admin\Views\ApplicationUser\Index.cshtml"
               Write(Html.DisplayFor(m => item.Name));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                </td>\r\n                <td>\r\n                    ");
#nullable restore
#line 55 "C:\Users\dipalik\Music\VM_C#\DOTNETCORE\AreasfinalDemo\Areas\Admin\Views\ApplicationUser\Index.cshtml"
               Write(Html.DisplayFor(m => item.Email));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                </td>\r\n                <td>\r\n                    ");
#nullable restore
#line 58 "C:\Users\dipalik\Music\VM_C#\DOTNETCORE\AreasfinalDemo\Areas\Admin\Views\ApplicationUser\Index.cshtml"
               Write(Html.DisplayFor(m => item.PhoneNumber));

#line default
#line hidden
#nullable disable
            WriteLiteral("\r\n                </td>\r\n                <td>\r\n");
#nullable restore
#line 61 "C:\Users\dipalik\Music\VM_C#\DOTNETCORE\AreasfinalDemo\Areas\Admin\Views\ApplicationUser\Index.cshtml"
                     if (item.LockoutEnd != null && item.LockoutEnd > DateTime.Now)
                    {

#line default
#line hidden
#nullable disable
            WriteLiteral("                        <label>Disabled</label>");
#nullable restore
#line 63 "C:\Users\dipalik\Music\VM_C#\DOTNETCORE\AreasfinalDemo\Areas\Admin\Views\ApplicationUser\Index.cshtml"
                                               }

#line default
#line hidden
#nullable disable
            WriteLiteral("                </td>\r\n                <td>\r\n");
#nullable restore
#line 66 "C:\Users\dipalik\Music\VM_C#\DOTNETCORE\AreasfinalDemo\Areas\Admin\Views\ApplicationUser\Index.cshtml"
                     if (item.LockoutEnd == null || item.LockoutEnd < DateTime.Now)
                    {

#line default
#line hidden
#nullable disable
            WriteLiteral("                        ");
            __tagHelperExecutionContext = __tagHelperScopeManager.Begin("a", global::Microsoft.AspNetCore.Razor.TagHelpers.TagMode.StartTagAndEndTag, "f39f22606b3b7aaadbc774a054c401577482c1e610841", async() => {
                WriteLiteral("\r\n                            <i class=\"fas fa-edit\"></i>\r\n                        ");
            }
            );
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper = CreateTagHelper<global::Microsoft.AspNetCore.Mvc.TagHelpers.AnchorTagHelper>();
            __tagHelperExecutionContext.Add(__Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper);
            __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_3);
            __tagHelperExecutionContext.AddHtmlAttribute(__tagHelperAttribute_4);
            __Microsoft_AspNetCore_Mvc_TagHelpers_AnchorTagHelper.Action = (string)__tagHelperAttribute_5.Value;
            __tagHelperExecutionContext.AddTagHelperAttribute(__tagHelperAttribute_5);
            BeginAddHtmlAttributeValues(__tagHelperExecutionContext, "href", 1, global::Microsoft.AspNetCore.Razor.TagHelpers.HtmlAttributeValueStyle.DoubleQuotes);
#nullable restore
#line 68 "C:\Users\dipalik\Music\VM_C#\DOTNETCORE\AreasfinalDemo\Areas\Admin\Views\ApplicationUser\Index.cshtml"
AddHtmlAttributeValue("", 1770, Url.Action("Edit/" + item.Id), 1770, 30, false);

#line default
#line hidden
#nullable disable
            EndAddHtmlAttributeValues(__tagHelperExecutionContext);
            await __tagHelperRunner.RunAsync(__tagHelperExecutionContext);
            if (!__tagHelperExecutionContext.Output.IsContentModified)
            {
                await __tagHelperExecutionContext.SetOutputContentAsync();
            }
            Write(__tagHelperExecutionContext.Output);
            __tagHelperExecutionContext = __tagHelperScopeManager.End();
            WriteLiteral("\r\n                        <a type=\"button\" class=\"btn btn-danger\"");
            BeginWriteAttribute("href", " href=\"", 1954, "\"", 1991, 1);
#nullable restore
#line 71 "C:\Users\dipalik\Music\VM_C#\DOTNETCORE\AreasfinalDemo\Areas\Admin\Views\ApplicationUser\Index.cshtml"
WriteAttributeValue("", 1961, Url.Action("Delete/"+item.Id), 1961, 30, false);

#line default
#line hidden
#nullable disable
            EndWriteAttribute();
            WriteLiteral(">\r\n                            <i class=\"fas fa-trash-alt\"></i>\r\n                        </a>");
#nullable restore
#line 73 "C:\Users\dipalik\Music\VM_C#\DOTNETCORE\AreasfinalDemo\Areas\Admin\Views\ApplicationUser\Index.cshtml"
                            }

#line default
#line hidden
#nullable disable
            WriteLiteral("                </td>\r\n\r\n            </tr>\r\n");
#nullable restore
#line 77 "C:\Users\dipalik\Music\VM_C#\DOTNETCORE\AreasfinalDemo\Areas\Admin\Views\ApplicationUser\Index.cshtml"
}

#line default
#line hidden
#nullable disable
            WriteLiteral("    </table>\r\n</div>");
        }
        #pragma warning restore 1998
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.ViewFeatures.IModelExpressionProvider ModelExpressionProvider { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IUrlHelper Url { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.IViewComponentHelper Component { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IJsonHelper Json { get; private set; }
        [global::Microsoft.AspNetCore.Mvc.Razor.Internal.RazorInjectAttribute]
        public global::Microsoft.AspNetCore.Mvc.Rendering.IHtmlHelper<IEnumerable<AreasfinalDemo.Models.AppliccationUser>> Html { get; private set; }
    }
}
#pragma warning restore 1591