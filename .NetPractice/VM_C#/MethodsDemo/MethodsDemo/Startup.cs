using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(MethodsDemo.Startup))]
namespace MethodsDemo
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
